package cucumber;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIStepDefs {
	
	RequestSpecification request;
	Response response;
	
	@Given("I have the base URI {string}")
	public void i_have_the_base_uri(String BaseURI) {
	    // Write code here that turns the phrase above into concrete actions
	    
		request = RestAssured.given()
							 .baseUri(BaseURI);
		
	}

	@When("I perform the Get Operation")
	public void i_perform_the_get_operation() {
	    // Write code here that turns the phrase above into concrete actions
	    
		response = request.get();
		
	}

	@Then("I should get the response")
	public void i_should_get_the_response() {
	    // Write code here that turns the phrase above into concrete actions
	    
		Assert.assertNotNull(response);
		
	}

	@Then("Response Code should be {int}")
	public void response_code_should_be(int ResponseCode) {
	    // Write code here that turns the phrase above into concrete actions
	    
		int actResCode = response.getStatusCode();
		Assert.assertEquals(actResCode, ResponseCode);
		
	}

}
