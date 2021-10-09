package hung.com.performance;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Mục tiêu của phần này là bắt tất cả lỗi và exception trong quá trình Routing
 * Sau khi bắt lỗi sẽ trả về 1 page thống nhất
 *
 */
public class App3_stream_vs_for {

	// getLogger() sẽ lấy loggerName =  ClassFullName gồm cả packageName 
	static Logger log = LogManager.getLogger();

	public static void main(String[] args) {
		
		List<Integer> list = createList();
		/**
		 * có thể đổi thứ tự gọi hàm để test cho công bằng
		 * 
		 */
		for (int i = 0; i < 4; i++) {
			test_for(list);
			test_foreach(list);
		}

	}
	
	public static List<Integer> createList() {
		List<Integer> list = new ArrayList<>();
		
		/**
		 * Thường test với số lớn thì mới chính xác 
		 * Để ý hàm system.nanoTime() có sai số lớn 250ns nên phải test với số lớn mới chính xác
		 */
		for (int i = 0; i < 1000000; i++) {
			list.add(i);
		}
		
		return list;
	}
	
	public static void test_for(List<Integer> list) {
		
		long timeNano1 = System.nanoTime();
		long total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += i;
		}
		long timeNano2 = System.nanoTime();
		log.debug("test_for: " + (timeNano2 -timeNano1) + " ns"); 
	}
	
	/**
	 * foreach rất ngốn tài nguyên. Vì gọi function thì sẽ có prolog và Epilog code
	 * Phép đo 1 triệu cho thấy nhiều lúc gấp 10 lần time.
	 * Java8 tuy tiện nhưng phải trả giá rất lớn về performance
	 */
	static public long total;
	public static void test_foreach(List<Integer> list) {
		
		long timeNano1 = System.nanoTime();
		total = 0;
		list.forEach((i) -> {
			total += i;
		});
		long timeNano2 = System.nanoTime();
		log.debug("test_foreach: " + (timeNano2 -timeNano1) + " ns"); 
	}

}
