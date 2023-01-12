package CrudoperationwitoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getoperation {
	@Test
	private void get() {
		//step1 create a pre requisite 
		// step2 perform the action
		Response resp = RestAssured.get("http://rmgtestingserver:8084/projects");
		//step3
		resp.then().log().all();
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(200, actstatus);

	}

}
