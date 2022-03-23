package hung.com.java17;

import java.util.Objects;

/**
 * 
 * @author hungnm2
 *
 */
public record MyRecord(String name, String address) {
    public MyRecord {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }
    public MyRecord(String name) {
        this(name, "Unknown");
    }
    
    public static void main(String[] args) {
		var test = new MyRecord("name", "Address 1");
		
		System.out.println(test.name());
		System.out.println(test.address());
	}

}
