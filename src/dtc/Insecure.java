package dtc;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

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
	
	/**
	 * 
	 */
	public void intOverflow() {
		//2147483647, the returned value will be -2147483648
		int max = Integer.MAX_VALUE;
		int overflow = max + 1;
		
	}

	public static byte[] hash() {
		return hashPassword("password".toCharArray(), null, 100, 128);
	}
	
   public static byte[] hashPassword( final char[] password, final byte[] salt, final int iterations, final int keyLength ) {
	   
       try {
           SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
           PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
           SecretKey key = skf.generateSecret( spec );
           byte[] res = key.getEncoded( );
           return res;
 
       } 
       catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
           throw new RuntimeException( e );
       }
   }
}
