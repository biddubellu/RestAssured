package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Staticvalidation {

	@Test
	public void dynamic() {
		
		//precondition
		
		String expecteddata="TY_PROJ_11111";
		baseURI="http://rmgtestingserver";
		 port=8084;
		 //action
		 Response resp= when().get("/projects");
		
		 //validation
		 
		 String actdata=resp.jsonPath().get("[0].projectId");
		 System.out.println(actdata);
		 Assert.assertEquals(actdata, expecteddata);
		 System.out.println("data verified");
		 resp.then().log().all();
	}
}
