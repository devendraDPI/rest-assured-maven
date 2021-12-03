package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	
	@Test
	public void PutCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		
		Map<String, Object> PutBody = new HashMap<String, Object>();
		PutBody.put("name", "Bob");
		PutBody.put("salary", "6000");
		
		Response response = request.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body(PutBody)
								   .put("/employees/18");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		
		//==============Verification Of Response Code====================
		
		int ActResponse = response.statusCode();
		int ExpResponse = 200;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
	}

}
