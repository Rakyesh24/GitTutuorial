package stepdefs;


import io.cucumber.java.en.*;


public class AddTwoNumber {

	int a=5,b=8;
	int c;
	@Given("a and b")
	public void a_and_b() {
	    System.out.println("A:"+a);
	    System.out.println("B:"+b);
	}

	@When("a and b are added")
	public void a_and_b_are_added() {
	   c=a+b;
	}

	@Then("validate result")
	public void validate_result() {
		System.out.println("C:"+c);
	}

	
}
