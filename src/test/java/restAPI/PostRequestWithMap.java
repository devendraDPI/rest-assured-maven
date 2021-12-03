package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	
	@Test
	public void PostCall() {
		

		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		
		Map<String, Object> PostBody = new HashMap<String, Object>();
		PostBody.put("name", "Virat");
		PostBody.put("salary", "6000");
		
		Response response = request.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body(PostBody)
								   .post("/employees/create");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		
		//==============Verification Of Response Code====================
		
		int ActResponse = response.statusCode();
		int ExpResponse = 201;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
	}
	

}
