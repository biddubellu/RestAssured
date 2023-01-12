package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import java.util.List;
import org.testng.annotations.Test;


import io.restassured.response.Response;
import junit.framework.Assert;

public class dynamicvalidation1 {
	@Test
	public void dynamic() {
		
		//precondition
		
		String expecteddata="TY_PROJ_11111";
		baseURI="http://rmgtestingserver";
		 port=8084;
		//action
		 Response resp= when().get("/projects");
		 
		 //validation
		 boolean flag=false;
		List<String> pid = resp.jsonPath().get("projectId");
		 for(String p:pid) {
			 if(p.equalsIgnoreCase(expecteddata)){
				 flag=true;
				 
			 }
		 }
		Assert.assertTrue(flag);
		System.out.println("data verified");
}
}