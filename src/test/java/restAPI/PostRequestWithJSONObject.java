package restAPI;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJSONObject {
	
	@Test
	public void PostCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		
		JSONObject PostBody = new JSONObject();
		PostBody.put("name", "Virat");
		PostBody.put("salary", "12000");
		
		Response response = request.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body(PostBody.toString())
								   .post("/employees/create");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		
		//==============Verification Of Response Code====================
		
		int ActResponse = response.statusCode();
		int ExpResponse = 201;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
		//==============Verification Of Response Body====================
		
		JsonPath jpath = response.jsonPath();
        String ActName = jpath.get("name");
        String ExpName = "Virat";
        AssertJUnit.assertEquals(ActName, ExpName);

		
	}

}
