package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParameter {
	
	@Test
	public void GetCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Response response = request.param("id", "1").get("/employees");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		
		//==============Verification Of Response Code====================
		
		int ActResponse = response.statusCode();
		int ExpResponse = 200;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
		//==============Verification Of Headers==========================
		
		System.out.println(response.getHeaders());
		
		String ActHeader = response.getHeader("Content-Type");
		String ExpHeader = "application/json; charset=utf-8";
		AssertJUnit.assertEquals(ActHeader, ExpHeader);
		
		//==============Verification Of Response Body====================
		
		AssertJUnit.assertTrue(ResponseBody.contains("Pankaj"));
		
		JsonPath jpath = response.jsonPath();
		List <String> Names = jpath.get("name");
		String ActName = Names.get(0);
		String ExpName = "Pankaj";
		AssertJUnit.assertEquals(ActName, ExpName);
		
	}
	

}
