package authorization;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import pojo.pojoclass;

public class barertoken {
	@Test
	public void token() {
		baseURI ="https://api.github.com";
		JSONObject jobj= new JSONObject();
		jobj.put("name", "bid");
		
		given()
		 .auth()
		 .oauth2("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")
		 .body(jobj)
		 .contentType(ContentType.JSON)
		 
	    .when()
	     .post("/user/repos")
	     
	    .then().log().all().assertThat().statusCode(201);
}
	}


