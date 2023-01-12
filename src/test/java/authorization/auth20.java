package authorization;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class auth20 {
	@Test
	public void oauthAuthentication()
	{
		//Create a request to generate accesss token 
		Response resp = given()
		 .formParam("client_id", "hhhh")
		 .formParam("client_secret", "77c5a3068f827de57960c37fe041180d")
		 .formParam("grant_type", "client_credentials")
		 .formParam("redirect_uri", "http://sssss.com")
		 .formParam("code", "authorization_code")
		 
	    .when()
	     .post("http://coop.apps.symfonycasts.com/token");
	     
	    //Capture the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		
		//Create another request and use the token to access the APIs
		given()
		 .auth().oauth2(token)
		 .pathParam("USER_ID", 4244)
		 
		.when()
		 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		 
		.then().log().all();
		 
		 
	}

}
