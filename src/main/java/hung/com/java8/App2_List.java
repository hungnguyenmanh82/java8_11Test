package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
		 * Cách 1: forEach
		 * jump vào forEach(FunctionPointer) để xem cấu trúc functionPointer
		 * ---
		 * dùng forEach có performance rất tệ (ko nên dùng)
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

		/**
		 * Cách 2: (nên dùng) truyền thống
		 * cách này cho performance tốt nhất
		 */
		Iterator<String > it = list.iterator();
		
		while(it.hasNext()) {
			String v = it.next();
			System.out.println(v);
		}
	}

}
