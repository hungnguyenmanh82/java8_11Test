package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class App23_List_sort_cach1_ok {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");


		List<String> sortedList = list.stream()
		.sorted((String o1, String o2)->{ //comparator
			/**
			 * return = 0 =>     o1 = o2
			 * return = negative -1 =>    o1 < o2  
			 * return = positive  1 =>    o1 > o2
			 *  Nếu muốn thay đổi order thì Thay đổi giá trị return ở trên giưa 1 và -1
			 */
			return o1.compareTo(o2); // String có sẵn hàm comparable nên mới vậy
		}).collect(Collectors.toList());
		
		sortedList.forEach(o-> System.out.println(o));   //forEach này ko tiến hành từ last Element đc
		
	}

}
