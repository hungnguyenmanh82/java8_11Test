package hung.com.concurrentmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * ConcurrentMap hỗ trợ multi thread cùng truy cập vào 1 Map mà ko bị lock lẫn nhau
 * Dựa trên cơ chế fragment lock từng phần
 * 
 * Thư viện Vertx cùng dùng nó (vd: trường hợp blocking-code truy cập vào Map của vertx ContextInternal)
 */
public class App1_compute {

	public static void main(String[] args)   
	{   
		
		ConcurrentMap<String, String> chm = new ConcurrentHashMap<String, String>();   
		//put is used to add value to map  
		chm.put("1", "1");   
		chm.put("2", "10");   
		chm.put("3", "100");   
		chm.put("4", "2");   
		chm.put("5", "20");   
		chm.put("6", "200");   

		System.out.println("Values in map with detail:" + chm.toString());

		/**
		 * compute(key, function) là kết hợp của hàm .get() và hàm put()
		 * lấy giá trị .get(key) ra và tính toán lại đẩy vào put(key, NewValue)
		 * ----
		 * tính toán lại giá trị cho trường hợp: key = "6"
		 * 
		 */
		chm.compute("6", (key , value)->{ 
			/**
			 * key = "6",  (kiểu String)
			 * value = "200"  (current value)
			 */
			return (value + 100);  // = new value = "200" + "100" = 200100
		});

		System.out.println("Map after using  compute(): "  + chm);   
		
	}  

}
