package pack1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest {
	@BeforeTest
	public void URISetUp() {
		RestAssured.baseURI="http://localhost:3000";
	}
	@Test
	public void ModifyData() {
		GetterSetter gs=new GetterSetter();
		//gs.setPhoneNumber("917-525-8959");
		gs.setFirstName("Tarek");
		RequestSpecification rs=RestAssured
				.given()
				.body(gs)
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.PATCH, "/Student/3");//id 3
		System.out.println("Response body is : "+resp.asString());
	}

}
