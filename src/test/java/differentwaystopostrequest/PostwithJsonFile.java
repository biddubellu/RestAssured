package differentwaystopostrequest;

import java.io.File;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostwithJsonFile {
	@Test
	public void jsonfile() {
		 File file=new File("./src/test/resources/Biddappa.json");
		 baseURI="http://rmgtestingserver";
		 port=8084;
		 
		 given() .body(file).contentType(ContentType.JSON)
		 .when().post("/addProject")
		 .then().log().all();
		 
		 
		 
		 
	}

}
