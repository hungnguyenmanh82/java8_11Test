package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class App232_List_sort_cach2_bad {

	public static class User {

		private String name;
		private int age;

		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "User{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}

	public static void main(String[] args) {
		List<User> users = Arrays.asList(
				new User("C", 30),
				new User("D", 40),
				new User("A", 10),
				new User("B", 20),
				new User("E", 50));


		// cách 1:
		/*List<User> sortedList = users.stream()
				.sorted((o1, o2) -> o1.getAge() - o2.getAge())
				.collect(Collectors.toList());*/

		// cách 2:
		/**
		 * functionPointer này bắt buộc phải có khởi tạo Object ( vì ko phải static function)
		 * Object đc xem là input implicit => qui tắc của Java ngầm định
		 * Ta sẽ bắt gặp cánh dùng này rất thường xuyên
		 * User::getAge = int getAge()  => int functionPoint(User o) 
		 */
		List<User> sortedList = users.stream()
				.sorted(Comparator.comparingInt(User::getAge))   
				.collect(Collectors.toList());

		/**
		 * cách viết implicit biến
		 */
		sortedList.forEach(System.out::println);





	}

}
