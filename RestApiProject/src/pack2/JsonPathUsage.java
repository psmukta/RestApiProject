package pack2;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class JsonPathUsage {
	@BeforeTest
	public void URISetUp() {
		RestAssured.baseURI="http://localhost:3000";
	}
	@Test
	public void JsonPathUsageTest() {
		RequestSpecification rs=RestAssured
				.given()
				.body(" ")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.GET, "/Student");
		System.out.println("Response Body is : "+resp.asString());
		JsonPath jsp=resp.jsonPath();
		List<Student>allStudent=jsp.getList("Student", Student.class);
		for(Student stud:allStudent) {
			System.out.println("Id is : "+stud.id);
			System.out.println("First Name  is : "+stud.FirstName);
			System.out.println("Last Name  is : "+stud.LastName);
		}
	}
}
