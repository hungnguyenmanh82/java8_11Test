package hung.com.map.concurrent_map;

import java.util.HashMap;

/**
 * ConcurrentMap hỗ trợ multi thread cùng truy cập vào 1 Map mà ko bị lock lẫn nhau
 * Dựa trên cơ chế fragment lock từng phần
 * 
 * Thư viện Vertx cùng dùng nó (vd: trường hợp blocking-code truy cập vào Map của vertx ContextInternal)
 */
public class App1_computeIfPresent {

    public static void main(String[] args)   
    {   
        HashMap<String, Integer> mapcon = new HashMap<>();   
        mapcon.put("k1", 100);   
        mapcon.put("k2", 200);   
        mapcon.put("k3", 300);   
        mapcon.put("k4", 400);   
    
        System.out.println("HashMap values :\n " + mapcon.toString());   
   
        /**
         * key = "k4", "k5" là giá trị đã tồn tại trong Map rồi
         */
        Integer value = mapcon.computeIfPresent("k4", (key , val)  -> val + 100);
         
        mapcon.computeIfPresent("k5", (key , val)  -> val + 100);   
        
        System.out.println("New HashMap after computeIfPresent :\n "+ mapcon);   
    }    

}
