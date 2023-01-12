package CRUDwithBDD;
import static io.restassured.response.Response.*;

import java.util.Random;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class put {
	@Test
	public void  updatedata() {
		JSONObject job=new JSONObject();
		job.put("createdBy", "Bid"+new Random().nextInt(500));
		job.put("projectName", "TYSS"+new Random().nextInt(500));
		job.put("status", "Completed");
		job.put("teamSize", 12);


		baseURI="http://rmgtestingserver";
		port=8084;

		given()
		.body(job)
		.contentType(ContentType.JSON)
		
		
		//step2 perform action 
		.when()
		.put("/projects/TY_PROJ_9566")
		
		
		//step3 validation 
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
