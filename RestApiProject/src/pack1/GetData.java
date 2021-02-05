package pack1;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetData {
	@BeforeTest
	public void URISetUp() {
		RestAssured.baseURI="http://localhost:3000";
		//RestAssured.baseURI="http://www.restapi.demoqa.com/utilities/books/getallbooks";
	}
	
	@Test
	public void GetRequest() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.GET, "/Student");
		System.out.println("Response body is : "+resp.asString());
	
	 }
	@Test
	public void ResponseCode() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.GET, "/Student");
		int responseCode=resp.statusCode();
		System.out.println("ResponseCode is : "+responseCode);
		Assert.assertEquals(responseCode, 200);
	
	}
	@Test
	public void Deserialization() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.GET, "/Student/1");
		JsonPath jsp=resp.jsonPath();//use jsonpath method
		System.out.println("ID received from response : "+jsp.get("id"));
		System.out.println("Firstname received \n from response :" +jsp.get("Firstname"));
		System.out.println("LastName received from response :\n" +jsp.get("LastName"));
		System.out.println("Email received from response :"+jsp.get("Email"));
	}
	
	
	
}
