package CRUDwithBDD;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class delete {
	@Test
	public void deletetheproject() {
		//step1 create a pre requisite 
		
				baseURI="http://rmgtestingserver";
				port=8084;

				
				//step2 perform action 
				when()
				.delete("/projects/TY_PROJ_9566")
				
				
				//step3 validation 
				.then()
				
				.statusCode(204)
				.contentType(ContentType.JSON)
				.log().all();


			
	}
	

}
