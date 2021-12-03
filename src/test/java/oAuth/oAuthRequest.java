package oAuth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class oAuthRequest {
	
	@Test
	public void PostCall() {
		
		RestAssured.given()
				   .auth()
				   .oauth2("auth_value")
		   		   .baseUri("https://api.github.com")
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .body("{\n" + 
				   		"	\"name\": \"PostmanTest\",\n" + 
				   		"	\"desription\": \"Test Repo from eclipse\",\n" + 
				   		"	\"homepage\": \"https://github.com/\",\n" + 
				   		"	\"private\": false,\n" + 
				   		"	\"has_issues\": true,\n" + 
				   		"	\"has_projects\": true,\n" + 
				   		"	\"has_wiki\": true\n" + 
				   		"}")
				   .when()
				   .post("/user/repos")
				   .then()
				   .statusCode(201)
				   .log()
				   .all();
		
	}

}
