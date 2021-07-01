package hung.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App6_char_set {
	public static void main(String[] args) {
		String abc = null;
		/**
		 * java char = 2 byte = utf16 character
		 */
		try {
			abc.charAt(0);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
