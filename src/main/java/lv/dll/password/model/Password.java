package lv.dll.password.model;

import java.security.SecureRandom;

public class Password {

	static String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	static String NUMERIC = "0123456789";
	static String SPECIAL_CHARS = "!@#$%^&*_=+-/";
	
	static SecureRandom random = new SecureRandom();  
	
	public static String generateRandomPassword(int lenght, boolean useSpecial_Chars, boolean useNumeric, boolean useALPHACAPS) {
		
		String password = "";
		
		String complexity = ALPHA;
		
		if (useSpecial_Chars) {
		
			complexity += SPECIAL_CHARS;
		}
		
		if (useNumeric) {
			
			complexity += NUMERIC;
		}
		
		if (useALPHACAPS) {
	
			complexity += ALPHA_CAPS;
		}
		
		for (int i=0;i<lenght;i++) {

		    password += complexity.charAt(random.nextInt(complexity.length()));
		}
		
		return password;
	
}

}