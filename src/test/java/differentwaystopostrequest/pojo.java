package differentwaystopostrequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo.pojoclass;

public class pojo {
	@Test
	
	public void createpojo() {
		
		
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		pojoclass cpj=new pojoclass("Bid"+new Random().nextInt(500),"TYYY"+new Random().nextInt(500),"Completed",5);
		
		given()
		.body(cpj)
		.contentType(ContentType.JSON)
		
		
		//step2 perform action 
		.when()
		.post("/addProject")
		
		
		//step3 validation 
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

	}

}
