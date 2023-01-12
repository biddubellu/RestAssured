package differentwaystopostrequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Postwithformdata {
	@Test
	public void jsonfile() {
		
		 baseURI="http://rmgtestingserver";
		 port=8084;
		 HashMap hm= new HashMap();
		 hm.put("createdBy", "Bid"+new Random().nextInt(500));
			hm.put("projectName", "TYSS"+new Random().nextInt(500));
			hm.put("status", "Completed");
			hm.put("teamSize", 12);
		 
		 given() .body(hm).contentType(ContentType.JSON)
		 .when().post("/addProject")
		 .then().log().all()
		 .time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS);
		 
		 
		 
		 
		 
	}

}
