package hung.com.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App32_break_multi_labels {
	private static Logger log = LogManager.getLogger(); 

	public static void main(String[] args) {
		String test ="abc";
		
		LABEL_1:{
			LABEL_2:{
				if (test.equals("abc")) {
					log.debug("ok");
					break LABEL_1;
				}
				log.debug("========== in LABEL_2: after break");
				
			}
			log.debug("========== in LABEL_1");
		}

		log.debug("========== end app");
	}

}
