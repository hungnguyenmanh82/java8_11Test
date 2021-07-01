package hung.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
Find(funtionPointer): tìm kiếm phần tử thỏa mãn điều kiện functionPointer = predicate
foreach(funtionPointer): duyệt array
filter(fp): lọc các giá trị thỏa điều kiện functionpoint = predicate => return array gồm các phần tử thỏa mãn điều kiện predicate.
 map(funtionPointer): convert tới Array mới => return array
 slice(): trích xuất Array là tập con của Array này 
 join(): kết hợp các phần tử của Array thành 1 String ngăn cách bởi Separator => tạo Json Array hoặc *.csv file.
reduce():  duyệt array mà có 1 biến accumulate cộng rồn giá trị (giúp ghi nhớ giá trị cộng rồn)

 */
public class App5_reduce {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("value1", "value2", "value3", 
				"value4", "value5");

		/**
		 * Reduce: là thuật ngữ để chỉ việc accummulate dữ liệu từ nhiều nguồn
		 * Thuật ngữ này cũng hay dùng trong hệ phân tán để tổng hợp dữ liệu tính toán từ nhiều
		 * máy chạy phân tán.
		 * vd: tìm kiếu dữ liệu trên Database chạy phân tán. Mỗi Database sẽ chữa 1 phần của 1 table lớn
		 */
		/**
		 * Optional<T>: là kiểu cho phép check null hay ko => giống với TypeScript "?"
		 */
		Optional<String> longestString = words.stream() 
				.reduce((accumulator, word)-> {
					/**
					 *  xem log sẽ hiểu ngay reduce hoạt động thế nào
					 *  word1 = luôn chứa accumulate là giá trị trả về của Accumulate function trc đó
					 *  word2 = giá trị trong array
					 */
					System.out.println("\n accumulate =" + accumulator);
					System.out.println("word =" + word);
					return accumulator + word;    // return accumulator là input của next reduce()
				}); 
		
		longestString.ifPresent(st->System.out.println(st)); 
	}
}
