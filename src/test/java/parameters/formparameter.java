package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class formparameter {
	@Test
	public void path() {
		
		given().formParam("createdBy", "Pemmanda")
		.formParam("projectName", "TYSSS")
		.formParam("status", "created")
		.formParam("teamSize", 12)
		.when().post("http://rmgtestingserver:8084/addProject")
		.then().assertThat()
		.statusCode(201)
		.log().all();
		
		
		
		
	}

}
