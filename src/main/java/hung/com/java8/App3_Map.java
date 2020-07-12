package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class App3_Map {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);
		map.put("F", 60);
		
		// Java 7
		for (Map.Entry<String, Integer> entry : map.entrySet() ) {
			System.out.println("{"+entry.getKey()+"," + entry.getValue() + "}");
		}
		
		System.out.println("=========================== foreach ====================");
		/**
		 * jump to forEach(functionPointer) để xem cú pháp input
		 */
		map.forEach((key, value)->{
			System.out.println("{"+key+"," + value + "}");
		});

	}

}
