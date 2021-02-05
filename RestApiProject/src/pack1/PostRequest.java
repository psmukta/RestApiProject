package pack1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@BeforeTest
	public void URISetUp() {
		RestAssured.baseURI="http://localhost:3000";
	}
	@Test
	public void AddNewData() {
		GetterSetter gs=new GetterSetter();
		gs.setId(4);
		gs.setFirstName("Tanvirul");
		gs.setLastName("Islam");
		gs.setEmail("tipu1234@yahoo.com");
		RequestSpecification rs=RestAssured
				.given()
				.body(gs)
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.POST, "/Student");
		System.out.println("Response body is : "+resp.asString());
	}

}
