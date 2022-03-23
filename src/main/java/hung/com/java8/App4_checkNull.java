package hung.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class App4_checkNull {


	public static void main(String[] args) {
		String st = null;
		
		/**
		 * nên dùng Log4j2 để kiểm soát đc log đầu ra tốt hơn
		 * hàm này throw exception
		 * ----
		 * Null là trường hợp ít xảy ra, nên Throw exception ko ảnh hưởng tới performance chung
		 * Rất nhiều thư viện nổi tiếng dùng cách này
		 */
		Objects.requireNonNull(st);

	}

}
