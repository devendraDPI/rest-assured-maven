package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	
	@Test
	public void PutCall() {
		
		Map<String, Object> PutBody = new HashMap<String, Object>();
		PutBody.put("name", "Karan");
		PutBody.put("salary", "16000");
		
		RestAssured.given()
				   .baseUri("http://localhost:7000")
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .body(PutBody)
				   .when()
				   .put("/employees/8")
				   .then()
				   .statusCode(200)
				   .log()
				   .all();
		
	}

}
