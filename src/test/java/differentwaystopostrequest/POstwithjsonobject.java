package differentwaystopostrequest;
import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;

public class POstwithjsonobject {
@Test

public void json() {
	baseURI="http://rmgtestingserver";
	port=8084;
	
	JSONObject job=new JSONObject();
	job.put("createdBy", "Bid"+new Random().nextInt(500));
	job.put("projectName", "TYSS"+new Random().nextInt(500));
	job.put("status", "Completed");
	job.put("teamSize", 12);
	given()
	.body(job)
	.contentType(ContentType.JSON)
	
	
	//step2 perform action 
	.when()
	.post("/addProject")
	
	
	//step3 validation 
	.then()
	.log().all();
}
}
