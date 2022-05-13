package hung.com.map.tree_map;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
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
public class App2_TreeMap_search_range {
	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args)   
	{   

		TreeMap<Integer, String> map = new TreeMap<>();

		map.put(10, "value1");
		map.put(7, "value7");
		map.put(1, "value1");
		map.put(2, "value2_1");
		map.put(2, "value2_2"); // duy nhất 1 Value ứng với key (giá trị cũ sẽ bị xóa)
		map.put(8, "value8");
		map.put(12, "value12");

		// STEP 1*: search less than  .headMap(key,inclusive)
		/**
		 * SortedMap: là interface => đây bản chất vẫn là TreeMap extends
		 *  cái này sẽ tạo Map mới rồi copy sang => vừa ngốn tài nguyên, vừa tốn time
		 */
		SortedMap<Integer, String> sortedMapLess = map.headMap(10,true); // map chứa các giá trị <= 10
		
		log.debug("sortedMapLess = {}", sortedMapLess);
		
		// STEP 2*: search more than .tailMap(key,inclusive)
		SortedMap<Integer, String> sortedMapMore = map.tailMap(8,true); // map chưa các giá trị >= 8

		log.debug("sortedMapMore = {}", sortedMapMore);
		
		// STEP 3*: search range = search less + search more
		/**
		 * cái này sẽ tạo Map mới rồi copy sang => vừa ngốn tài nguyên, vừa tốn time
		 * NavigableMap<K,V> extends SortedMap<K,V>
		 * TreeMap implements NavigableMap
		 *  ----
		 *  subMap(lower, inclusive, higher, inclusive)
		 */
		NavigableMap<Integer, String> navigableMap =  map.subMap(2,true, 8, true);
		
		log.debug("search range navigableMap = {}", navigableMap);
	}  

}
