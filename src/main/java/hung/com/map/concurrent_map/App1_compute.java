package hung.com.map.concurrent_map;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ConcurrentMap hỗ trợ multi thread cùng truy cập vào 1 Map mà ko bị lock lẫn nhau
 * Dựa trên cơ chế fragment lock từng phần
 * 
 * Thư viện Vertx cùng dùng nó (vd: trường hợp blocking-code truy cập vào Map của vertx ContextInternal)
 */
public class App1_compute {
	private static final Logger log = LogManager.getLogger();
  
	public static void main(String[] args)   
	{   
		
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();   
		//put is used to add value to map  
		chm.put("1", "1");   
		chm.put("2", "10");   
		chm.put("3", "100");   
		chm.put("4", "2");   
		chm.put("5", "20");   
		chm.put("6", "200");   

		log.debug("======== Map before .compute(): {}", chm);

		/**
		 * compute(key, function) là kết hợp của hàm .get() và hàm put()
		 * lấy giá trị .get(key) ra và tính toán lại đẩy vào put(key, NewValue)
		 * -----
		 * Nhược điểm: nếu muốn giữ nguyên giá trị cũ thì vẫn phải write đè lên giá trị cũ với Put()
		 * ----
		 * tính toán lại giá trị cho trường hợp: key = "6"
		 * ----
		 * .compute() có thể dùng để tạo CAS (trong khi .put() ko thể tạo CAS đc)
		 * .compute() sẽ bị synchronized lâu hơn so với .put()
		 */
		// STEP 1: key tồn tại
		String value_key6 = chm.compute("6", (key , value)->{ 
			
			log.debug("<key,value> = <{},{}>", key, value);
			/**
			 * key = "6",  (kiểu String)
			 * value = "200"  (current value)
			 */
			// nếu return null thì Key này sẽ bị xóa khỏi map
			return (value + 100);  // = new value = "200" + "100" = 200100
		});

		
		// STEP 2: key ko tồn tại, tạo mới
		String value_key9 = chm.compute("9", (String key ,String value)->{ 
			
			log.debug("<key,value> = <{},{}>", key, value);

			return "value_9";  // = new value = "200" + "100" = 200100
		});

		// STEP 3: xóa key = 1 đi
		String value_key1 = chm.compute("1", (String key ,String value)->{

			log.debug("<key,value> = <{},{}>", key, value);

			return null;  // xóa key = 1 đi
		});
		log.debug("======= Map after .compute(): {}", chm);
		
	}  

}
