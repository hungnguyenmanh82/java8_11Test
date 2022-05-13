package hung.com.map.tree_map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * https://www.javatpoint.com/difference-between-hashmap-and-treemap#:
 * ------
 * TreeMap là sorted binary Tree
 * TreeMap dùng class Comparable của Key để sorting (ko dùng .hashCode() để compare) => Xem String class implement Comparable interface
 * Nó ko có synchronize nên ko hỗ trợ multi-thread cùng truy cập.
 * TreeMap dùng "Red-Black tree" để rebalance Search Tree
 * Trc khi tiến hành Delete/insert đều phải search với O(LogN) cơ số 2
 * ------
 * interator của TreeMap duy trì thứ tự    O(logn)
 * interator của HashMap ko duy trì thứ tự. O(1)
 * -----
 * 
 */
public class App1_TreeMap {
	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args)   
	{   

		TreeMap<Integer, String> map = new TreeMap<>();

		map.put(10, "value1");
		map.put(2, "value2_1");
		map.put(2, "value2_2"); // duy nhất 1 Value ứng với key (giá trị cũ sẽ bị xóa)
		map.put(8, "value8");
		map.put(12, "value12");

		String value = map.get(8);
		log.debug("value = {}", value);

		/**
		 * TreeMap là sorted binary Tree
		 *  interator của TreeMap duy trì thứ tự lớn nhỏ của key (có thể add hàm compare vào)
		 *  interator của HashMap ko duy trì thứ tự.
		 *  interator của LinkedHashMap duy trì thứ tự insert vào dãy (ko phải thứ tự key compare)
		 *  -----
		 *  HashMap s
		 */
		map.entrySet().iterator().forEachRemaining((Map.Entry<Integer,String> entry) -> {
			log.debug("entry = < {},{} >",entry.getKey(), entry.getValue());
		});

		

	}  

}
