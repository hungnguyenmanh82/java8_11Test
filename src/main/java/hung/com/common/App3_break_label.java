package hung.com.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App3_break_label {
	private static Logger log = LogManager.getLogger(); 

	public static void main(String[] args) {
		String test ="abc";
		
		LABEL_1:{
			if (test.equals("abc")) {
				log.debug("ok");
				break LABEL_1;
			}
			log.debug("========== after break");
			
		}
		log.debug("========== end app");
	}

}
