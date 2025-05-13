package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
https://mkyong.com/tutorials/java-8-tutorials/
 */
public class App24_List_map {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a", "b", "c");
		
		/**
		 * Map: là thuật ngữ để chỉ việc interceptor để format lại dữ liệu
		 * Thay đổi kiểu dữ liệu, hoặc thay đổi value => số phần tử item trong list ko đổi
		 * map 1:1 => tạo ra array mới
		 */
		//String::toUpperCase  là functionPoint
		List<String> myList = list.stream()
							  .<String>map(String::toUpperCase)
							  .collect(Collectors.toList());  // new List
		    
		System.out.println(myList.toString());
		
	}

}
