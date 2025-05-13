package hung.com.map.concurrent_map;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ConcurrentMap hỗ trợ multi thread cùng truy cập vào 1 Map mà ko bị lock lẫn nhau
 * Dựa trên cơ chế fragment lock từng phần
 * 
 * Thư viện Vertx cùng dùng nó (vd: trường hợp blocking-code truy cập vào Map của vertx ContextInternal)
 */
public class App1_computeIfAbsent {

	private static final Logger log = LogManager.getLogger();
	  
	
    public static void main(String[] args)   
    {   
          // crete a HashMap and add some values   
        HashMap<String, Integer> mapcon      = new HashMap<>();   
        mapcon.put("k1", 100);   
        mapcon.put("k2", 200);   
        mapcon.put("k3", 300);   
        mapcon.put("k4", 400); 
        
        log.debug("HashMap values :  " + mapcon.toString());    
       
        int value =  mapcon.computeIfAbsent("k1", (key) -> {
        	log.debug("======= check:");  // chỗ này ko đc gọi vì "k1" đã tồn tại trong HashMap
        	return 0;
        }); 
        
        log.debug("value = {}", value); // = 100 (đã tồn tại trong HashMap)
        
        /**
         * key = "k5", "k6" ko tồn tại trong HashMap thì gọi (key)->{}
         * nếu key tồn tại thì hàm compute trả về value tương ứng với key
         */
        value = mapcon.computeIfAbsent("k5", (key) -> 200 + 300);
        log.debug("key = k5, value = {}", value); // = 500
        mapcon.computeIfAbsent("k6", (key) -> 60 * 10);
        log.debug("key = k6, value = {}", value); // = 600
        
        // thứ tự ko chuẩn, muốn thứ tự insert phải dùng LinkedHashMap
        log.debug("===== New HashMap after computeIfAbsent : "+ mapcon);   
    } 

}
