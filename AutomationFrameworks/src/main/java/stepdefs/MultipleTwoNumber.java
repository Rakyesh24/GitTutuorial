package stepdefs;

import org.testng.Assert;

import io.cucumber.java.en.*;

public class MultipleTwoNumber {
	Integer result=0;
	int c,d;
	@Given("{int} and {int}")
	public void and(Integer int1, Integer int2) {
	   System.out.println("A"+int1);
	   System.out.println("B"+int2);
	   c=int1;
	   d=int2;
	}

	@When("c and d are multipled")
	public void c_and_d_are_multipled() {
		result=c*d;
	   
	}

	@Then("validate multiple {int}")
	public void validate_multiple(Integer int1) {
	    Assert.assertEquals(int1, result);
	}
}
