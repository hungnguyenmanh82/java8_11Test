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
		List<String> myList = list.stream()
							  .map(String::toUpperCase)
							  .collect(Collectors.toList());  // new List
		    
		System.out.println(myList.toString());
		
	}

}
