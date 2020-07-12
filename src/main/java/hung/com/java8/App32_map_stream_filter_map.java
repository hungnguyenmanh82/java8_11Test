package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

public class App32_map_stream_filter_map {

	public static class MyEntry implements Map.Entry<String,String>{
		
		String key;
		String value;
		
		public MyEntry(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public String getKey() {
			return key;
		}

		@Override
		public String getValue() {
			return value;
		}

		@Override
		public String setValue(String value) {
			return null;
		}
		
	} 
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);
		map.put("F", 60);
		
		System.out.println("=========================== filter ====================");
		/**
		 * Bản chất chuyển về kiểu List, Set và thao tác giống hệt List
		 */
		map.entrySet()   //trả về kiểu Set = tập hợp. 
		    .stream()
		    .filter(entry-> {
		    	return (entry.getValue() > 30);
		    })
		    .forEach(entry->{
		    	System.out.println("{"+entry.getKey()+"," + entry.getValue() + "}");
		    	
		    });
		
		System.out.println("=========================== map ====================");
		map.entrySet()   // Set<Map.Entry<K, V>> entrySet();
	    .stream()
	    .<Map.Entry<String, String>>map(entry-> {
	    	return new MyEntry(entry.getKey(), "value ok");
	    })
	    .forEach(entry->{
	    	System.out.println("{"+entry.getKey()+"," + entry.getValue() + "}");
	    	
	    });

	}

}
