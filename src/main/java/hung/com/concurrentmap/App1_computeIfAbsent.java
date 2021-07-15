package hung.com.concurrentmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentMap hỗ trợ multi thread cùng truy cập vào 1 Map mà ko bị lock lẫn nhau
 * Dựa trên cơ chế fragment lock từng phần
 * 
 * Thư viện Vertx cùng dùng nó (vd: trường hợp blocking-code truy cập vào Map của vertx ContextInternal)
 */
public class App1_computeIfAbsent {


	
    public static void main(String[] args)   
    {   
          // crete a HashMap and add some values   
        HashMap<String, Integer> mapcon      = new HashMap<>();   
        mapcon.put("k1", 100);   
        mapcon.put("k2", 200);   
        mapcon.put("k3", 300);   
        mapcon.put("k4", 400); 
        
        System.out.println("HashMap values :  " + mapcon.toString());    
        
        /**
         * key = "k5", "k6" ko tồn tại trong HashMap thì gọi (key)->{}
         * nếu key tồn tại thì hàm compute trả về value tương ứng với key
         */
        mapcon.computeIfAbsent("k5", (key) -> 200 + 300);   
        mapcon.computeIfAbsent("k6", (key) -> 60 * 10); 
        
        System.out.println("New HashMap after computeIfAbsent : "+ mapcon);   
    } 

}
