package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
https://mkyong.com/tutorials/java-8-tutorials/
 */
public class App2_List {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("item1");
		list.add("item2");
		list.add("item3");
		
		/**
		 * jump vào forEach(FunctionPointer) để xem cấu trúc functionPointer
		 */
		// viết tường minh kiểu Java => ko dùng
//		list.forEach(new Consumer<String>() {
//			public void accept(String item) {
//				System.out.println(item);
//			};
//		});
		
		// lambda syntax => ok
		list.forEach(item-> System.out.println(item));
	
		//cách viết khác
//		list.forEach(System.out::println);

		
	}

}
