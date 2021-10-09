package hung.com.performance;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Mục tiêu của phần này là bắt tất cả lỗi và exception trong quá trình Routing
 * Sau khi bắt lỗi sẽ trả về 1 page thống nhất
 *
 */
public class App2_system_timeNano {

	// getLogger() sẽ lấy loggerName =  ClassFullName gồm cả packageName 
	static Logger log = LogManager.getLogger();

	public static void main(String[] args) {

		long total = 0;
		int n = 1000;
		// như vậy giữa 2 lệnh này ngốn khá nhiều tài nguyên
		for (int i = 0; i < n; i++) {
			long timeNano1 = System.nanoTime();		
			long timeNano2 = System.nanoTime();
			log.debug("timeNano2 - timeNano1 = {} ns", (timeNano2 -timeNano1)); // = [0ns,1500ns]
			
			total += timeNano2 -timeNano1; 
			System.out.println();
		}
		
		double avarage = (double)total/n;
		log.debug("=================== avarage = {} ns", avarage);

	}

}
