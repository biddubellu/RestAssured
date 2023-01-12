package CrudoperationwitoutBDD;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class putoperation {
	@Test
	public void post() {
		//step 1 create the pre requisite -request body
		JSONObject job=new JSONObject();
		job.put("createdBy", "Bellu");
		job.put("projctName", "TYSS");
		job.put("status", "Completed");
		job.put("teamSize", 12);
		
		RequestSpecification req=RestAssured.given();
		req.body(job);
		req.contentType(ContentType.JSON);
		
		
		//step2 perform the action 

	 Response response = req.put("http://rmgtestingserver:8084/addProject/TY_PROJ_9992");
	 
	 //step3  validate the response
	 //response.then().log().all();
	 System.out.println(response.getContentType());
	 System.out.println(response.asString());
	 System.out.println(response.prettyPrint());
	 System.out.println(response.prettyPeek());
		 

}
}
