package restAPIChaining;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEndTest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		//========================= POST Call =========================
		
		RequestSpecification Postrequest = RestAssured.given();
		
		Map<String, Object> PostBody = new HashMap<String, Object>();
		PostBody.put("name", "Ratan");
		PostBody.put("salary", "4000");
		
		Response Postresponse = Postrequest.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body(PostBody)
								   .post("/employees/create");
		
		String ResponseBody = Postresponse.body().asString();
		System.out.println(ResponseBody);
		
		JsonPath jpath = Postresponse.jsonPath();
        String ResponseID = jpath.get("id").toString();
        
        //========================= PUT Call ==========================
        
        RequestSpecification Putrequest = RestAssured.given();
		
		Map<String, Object> PutBody = new HashMap<String, Object>();
		PutBody.put("name", "Ratan");
		PutBody.put("salary", "20000");
		
		Response Putresponse = Putrequest.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body(PutBody)
								   .put("/employees/" + ResponseID);
		ResponseBody = Putresponse.body().asString();
		System.out.println(ResponseBody);
		
		//========================= DELETE Call =======================
		
		RequestSpecification Deleterequest = RestAssured.given();
		Response Deleteresponse = Deleterequest.delete("/employees/" + ResponseID);
		
		//************************ DELETE Verification ****************
		
		int ActDeleteResponse = Deleteresponse.statusCode();
		int ExpDeleteResponse = 200;
		AssertJUnit.assertEquals(ActDeleteResponse, ExpDeleteResponse);
		
		//========================= GET Call ==========================
		
		RequestSpecification GetRequest = RestAssured.given();
		Response GetResponse = GetRequest.get("/employees" + ResponseID);
		
		//************************ GET Verification *******************
		
		int ActGetResponse = GetResponse.statusCode();
		int ExpGetResponse = 404;
		AssertJUnit.assertEquals(ActGetResponse, ExpGetResponse);
		
	}

}
