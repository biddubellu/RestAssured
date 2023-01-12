package parameters;

import org.testng.annotations.Test;
import static io.restassured.response.Response.*;
import  static io.restassured.RestAssured.*;

public class pathparameter {

	@Test
	public void path() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().pathParam("path", "TY_PROJ_11111")
		.when().get("/projects/{path}")
		.then().log().all();
		
		
		
		
	}
}
