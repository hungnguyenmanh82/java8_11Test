package hung.com.performance;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Mục tiêu của phần này là bắt tất cả lỗi và exception trong quá trình Routing
 * Sau khi bắt lỗi sẽ trả về 1 page thống nhất
 *
 */
public class App22_system_timeMillisecond {

	// getLogger() sẽ lấy loggerName =  ClassFullName gồm cả packageName 
	static Logger log = LogManager.getLogger();

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			getTimeMillis(); // ~3ns => nên dùng
			getTimeNano(); // ~25ns  => quá chậm
		}
	}
	
	public static void getTimeMillis() {
		long startNano = System.nanoTime();
		int n = 100000000;
		for (int i = 0; i < n; i++) {
			long timeMillis = System.currentTimeMillis();	
		}
		
		long stopNano = System.nanoTime();
		log.debug("totalTimeMillis = {} ns", (stopNano-startNano)/n );
	}
	
	public static void getTimeNano() {
		long startNano = System.nanoTime();
		int n = 100000000;
		for (int i = 0; i < n; i++) {
			long timeMillis = System.nanoTime();	
		}
		
		long stopNano = System.nanoTime();
		log.debug("totalNano = {} ns", (stopNano-startNano)/n );
		
	}

}
