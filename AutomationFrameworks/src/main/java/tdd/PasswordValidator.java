package tdd;

public class PasswordValidator {

	public boolean isValid(String str) {
		
		if(str.length() > 5 && str.length()<19) {
			return true;
		}
		
		
		return false;
		
	} 
}
