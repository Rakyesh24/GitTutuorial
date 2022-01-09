package tddtest;

import org.testng.annotations.Test;

public class TC_1 {
	@Test
	public void length() {

		String str = "TesterTesterTester1";
		System.out.println(str.length());

		try {
			if (str.length() < 6 && str.length()<18) {
				System.out.println("InCorrect");
			}
			else if (str.length() > 5 && str.length()<19) {
				System.out.println("Correct");
			}
			
		} catch (Exception e) {
			
		}
	}

}
