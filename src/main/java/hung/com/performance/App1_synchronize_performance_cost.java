package hung.com.performance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Mục tiêu của phần này là bắt tất cả lỗi và exception trong quá trình Routing
 * Sau khi bắt lỗi sẽ trả về 1 page thống nhất
 *
 */
public class App1_synchronize_performance_cost {

	// getLogger() sẽ lấy loggerName =  ClassFullName gồm cả packageName 
	static Logger log = LogManager.getLogger();
	
	public static void main(String... args) {
	    for (int i = 0; i < 3; i++) {
	        perfTest(new Vector<Integer>());
	        perfTest(new ArrayList<Integer>());
	    }
	}

	/**
	 * Kết quả: mỗi lệnh add/remove synchorinze: sẽ bị chậm 20ns so với ko synchronize.
	 *  Đồng nghĩa với các thread khác phải đợi ít nhất 20ns khi add/remove 1 phần tử. 
     * 1 synchronize() = 20ns. Nếu add 20item = 20 synchronize() 
     * Vd: threadA add 20item = 20item *20ns = 400ns => ThreadB sẽ phải chờ 400ns để đc quyền thao tác với dữ liệu.
	 */
	private static void perfTest(List<Integer> objects) {
	    long start = System.nanoTime();
	    final int runs = 1000000000;
	    for (int i = 0; i < runs; i += 20) {
	        // add items.
	        for (int j = 0; j < 20; j+=2)
	            objects.add(i);
	        // remove from the end.
	        while (!objects.isEmpty())
	            objects.remove(objects.size() - 1);
	    }
	    long time = System.nanoTime() - start;
	    System.out.printf("%s each add/remove took an average of %.1f ns%n", objects.getClass().getSimpleName(),  (double) time/runs);
	}

}
