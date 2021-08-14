package hung.com.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App2_goto_continue_break_for {
	private static Logger log = LogManager.getLogger(); 

	public static void main(String[] args) {
		int[] numbers= new int[]{100,18,21,30};

		/**
		 * Label dùng với continue, break
		 *  sau label bắt buộc là 1 loop {} nếu ko sẽ báo lỗi 
		 *  loop{}: là for, while, do
		 */
		int i =0 ,j = 0;
		
		OUTER:
		for(i = 0; i < 5 ; i++){  //while 1st
			i++;
			log.debug("********************************************* start while 1st");
			log.debug("1. i = " + i);
			if(i==1) {
				log.debug("continue OUTER; i = " + i);
				continue OUTER;
			}
			log.debug("2. i = " + i);
			if(i == 4) {
				log.debug("break while 1st: i = " + i);
				break; // break while 1st
			}
			log.debug("3. i = " + i);
			INNER:
				for(j = 0 ; j < 10 ; j++) { // while 2nd
					log.debug("+++++++++++++++++++++++++++++++ start while 2st");
					j++;
					log.debug("1. j = " + j);
					if(j==2) {
						log.debug("continue OUTER; i = {},  j = {} ",i, j);
						continue OUTER;
					}
					log.debug("2. j = " + j);
					
					if(j == 3) {
						log.debug("continue while 2nd; i = {},  j = {} ",i, j);
						continue; //continue while 2nd
					}
					log.debug("3. j = " + j);
					
					if(j==4) {
						log.debug("break while 1st: i = {},  j = {}", i, j);
						break; //break while 2nd
					}
					log.debug("------------ end of while 2nd:  i = {},  j = {}", i, j);
				}
			log.debug("======= end of while 1st:  i = {},  j = {}", i, j);
		}
	}

}
