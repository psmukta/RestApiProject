package pack1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	@BeforeTest
	public void URISetUp() {
		RestAssured.baseURI="http://localhost:3000";
	}
	//Delete request for specific id 
	@Test
	public void DeleteData() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.DELETE, "/Student/4");
		System.out.println("Response body is : "+resp.asString());
	}

}
