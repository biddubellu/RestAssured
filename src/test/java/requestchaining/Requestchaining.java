package requestchaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Random;

import pojo.pojoclass;

public class Requestchaining {
	@Test
	public void chain() {
		pojoclass pojo=new pojoclass("pems"+new Random().nextInt(500), "cit123" + new Random().nextInt(500), "created", 15);

		baseURI="http://rmgtestingserver";
		port=8084;


		Response res = given().
				body(pojo)
				.contentType(ContentType.JSON)
				.when()
				.post("/addProject");

		//capture the project id
		String proid = res.jsonPath().get("projectId");
		System.out.println(proid);
		res.then().log().all();	 

		//create a get request and pass proid as path parameter

		given()
		.pathParam("pid", proid)
		.when()
		.get("/projects/{pid}")
		.then()
		.assertThat().statusCode(200).log().all();
	}
}
