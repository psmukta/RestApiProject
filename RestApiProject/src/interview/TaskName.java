package interview;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TaskName {
	@BeforeTest
	public void URIsetUp(){
		RestAssured.baseURI="http://localhost/dotdash-project/fake-api-call.php";
		
		
	}
	
	@Test
	public void GetRequest() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.GET, "");
		System.out.println("Response body is : "+resp.asString());
	
	 }
	@Test
	public void ResponseCode() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.GET, "");
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
		Response resp=rs.request(Method.GET, "dotdash-project/fake-api-call.php");
		JsonPath jsp=resp.jsonPath();//use jsonpath method
		System.out.println("ID received from response : "+jsp.get("id"));
		System.out.println("Status received  from response :" +jsp.get("status"));
		System.out.println("Task Name received from response :" +jsp.get("task name"));
		System.out.println("Category received from response :"+jsp.get("category"));
		System.out.println("Due Date received from response :"+jsp.get("due date"));
		
	}
	
	

}
