package restAPI;

import org.testng.annotations.Test;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void GetCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/employees");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		
		JsonPath jpath = response.jsonPath();
		List <String> Names = jpath.get("name");
		//System.out.println(Names);
		for (int i=0;i<Names.size();i++) {
			
            System.out.println(Names.get(i));
            
		}
		
	}

}
