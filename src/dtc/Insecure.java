package dtc;

/*
 * @author: Jan
 * 
 */
public class Insecure {
	
	String username = "username";
	String password = "password";
	
	String nullReference = null;
	
	public Insecure() {
	}

	public String getNullReference() {
		return nullReference;
	}
	
	public String getPassword() {
		return password;
	}
	
}
