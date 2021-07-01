package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

/**
Find(funtionPointer): tìm kiếm phần tử thỏa mãn điều kiện functionPointer = predicate
foreach(funtionPointer): duyệt array
filter(fp): lọc các giá trị thỏa điều kiện functionpoint = predicate => return array gồm các phần tử thỏa mãn điều kiện predicate.
 map(funtionPointer): convert tới Array mới => return array
 slice(): trích xuất Array là tập con của Array này 
 join(): kết hợp các phần tử của Array thành 1 String ngăn cách bởi Separator => tạo Json Array hoặc *.csv file.
reduce():  duyệt array mà có 1 biến accumulate cộng rồn giá trị (giúp ghi nhớ giá trị cộng rồn)

 */
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
		
		/**
		 * Map: là thuật ngữ để chỉ việc interceptor nhặc format lại dữ liệu
		 * Thay đổi kiểu dữ liệu, hoặc thay đổi value => số phần tử item trong list ko đổi
		 */
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
