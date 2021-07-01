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
public class App1_initialize_List {

	public static void main(String[] args) {
		// JDK2
		List<String> list = Arrays.asList("one", "two", "three");
		
		// JDK 7
		List<String> list1 = new ArrayList<>();
		list1.add("one");
		list1.add("two");
		list1.add("three");
		
		// JDK 8
		/**
		 * Học từ JavaScript
		 * Stream: là class thêm vào ở Java 8 để xử lý với Array
		 */
		List<String> list2 = Stream.of("one", "two", "three").collect(Collectors.toList());
		
		// JDK 9
		// immutable => list ko thêm bớt item đc
		List<String> immutableList = List.of("one", "two", "three");
		
		// mutable => có thể thêm bớt item
		List<String> mutableList = new ArrayList<>(List.of("one", "two", "three"));
	}

}
