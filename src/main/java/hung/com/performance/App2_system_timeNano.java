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
		// như vậy giữa 2 lệnh này ngốn khá nhiều tài nguyên
		for (int i = 0; i < 1000; i++) {
			long timeNano1 = System.nanoTime();		
			long timeNano2 = System.nanoTime();
			log.debug("timeNano2 - timeNano1 = " + (timeNano2 -timeNano1)); // = [400ns,1500ns]
			
			total += timeNano2 -timeNano1; 
			System.out.println();
		}
		
		double avarage = (double)total/1000;
		log.debug("=================== avarage = "+ avarage);

	}

}
