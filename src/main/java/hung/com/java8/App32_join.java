package hung.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App32_join {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("one", "two", "three");
		
		String st = String.join(";", list);
		
		System.out.println(st);
	}
}
