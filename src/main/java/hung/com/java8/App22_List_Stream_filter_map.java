package hung.com.java8;

/**
https://mkyong.com/tutorials/java-8-tutorials/
 */
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
Find(funtionPointer): tìm kiếm phần tử thỏa mãn điều kiện functionPointer = predicate
foreach(funtionPointer): duyệt array
filter(fp): lọc các giá trị thỏa điều kiện functionpoint = predicate => return array gồm các phần tử thỏa mãn điều kiện predicate.
 map(funtionPointer): convert tới Array mới => return array
 slice(): trích xuất Array là tập con của Array này 
 join(): kết hợp các phần tử của Array thành 1 String ngăn cách bởi Separator => tạo Json Array hoặc *.csv file.
reduce():  duyệt array mà có 1 biến accumulate cộng rồn giá trị (giúp ghi nhớ giá trị cộng rồn)

 */

public class App22_List_Stream_filter_map {

	public static void main(String[] args) {
		/**
		 * Học từ JavaScript: tất cả các concepts đều giữ nguyên như ở javaScript và react programming
		 */
		List<String> list = Stream.of("one", "two", "three").collect(Collectors.toList());

		list.add("one");


		System.out.println("=========================== filter ====================");
		/**
		 *  Filter: mục đích là chỉ giữ lại các item thỏa mãn điều kiện = true.
		 *  filter(functionPoint):  jump vào để xem cấu trúc functionPoint
		 *  <R>functionpoint(<T>):  return R = false thì sẽ remove item
		 *  dùng Lambda syntax
		 */
		// stream(): là builder pattern và functionPointer là trọng tâm của Java8.
		list.stream()
		.filter(item-> item.equals("one"))     //return True: giữ lại item. False: loại bỏ item
		.forEach(item -> System.out.println(item)); 
		
		
		System.out.println("=========================== filter new list ====================");
		/**
		 *  tạo một List mới sau khi filter List cũ:
		 *  Filter tạo kiểu stream. Muốn tạo List mới từ filter thì phải gọi .collect()
		 */
		List<String> listFilter = list.stream()
									  .filter(item-> item.equals("two"))     // True: giữ lại item. False: loại bỏ item
									  .collect(Collectors.toList());    //tạo new List (List cũ vẫn giữ nguyên ko đổi)
		
		listFilter.add("AAAAAAAA");
		listFilter.forEach(item->System.out.println(item));
		
		System.out.println("=========================== filter .toArrays ====================");
		
		String[] arrString =  list.stream().filter(item-> item.equals("two"))     // True: giữ lại item. False: loại bỏ item
										  .toArray(size -> new String[size]);   // khởi tạo 1 mảng String, sau đó gán các item trong stream cho mảng này
		
		System.out.println(String.join(",", arrString));
		
		System.out.println("=========================== map1 ====================");
		/**
		 * map: mục đích là thay đổi giá trị của item => giống như encode/decode vậy
		 * fiter(functionPointer):
		 * <R>functionPointer(<T>):  input = <T>, output = <R>
		 * lưu ý <T> và <R> có thể khác kiểu
		 */
		list.stream()
		.<String>map(item->{
			if( item.equals("one")) {
				return "number 1";
			}
			return (item + "2");
		})     
		.forEach(item -> System.out.println(item));
		
		//
		System.out.println("=========================== check old List again ====================");
		list.forEach(item-> System.out.println(item));

		System.out.println("=========================== map2 ====================");
		/**
		 * <R>functionPointer(<T>):  input = <T>, output = <R>
		 * lưu ý <T> và <R> có thể khác kiểu
		 *  <R> = Boolean
		 *  <T> = String
		 */
		list.stream()
		.<Boolean>map(item->{   
			if( item.equals("one")) {
				return true;
			}
			return false;
		})     
		.forEach(item -> System.out.println(item));
		
		System.out.println("=========================== Stream to aray ====================");
		String[] array = list.stream()
							.filter(item-> item.equals("one"))     // True: giữ lại item. False: loại bỏ item)
							.<String>toArray(String[]::new);   //Integer[]::new, MyClass[]::new
		
		for(String s: array) {
			System.out.println(s);
		}
	}

}
