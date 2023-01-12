package CRUDwithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class get {
	@Test
	public void getoperation() {
		
		//step1 create a pre requisite 
		
		baseURI="http://rmgtestingserver";
		port=8084;

		
		//step2 perform action 
		when()
		.get("/projects")
		
		
		//step3 validation 
		.then()
		
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();


	}

}
