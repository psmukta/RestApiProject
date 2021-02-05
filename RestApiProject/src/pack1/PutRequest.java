package pack1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//https://www.youtube.com/watch?v=yDdBOspPp_c
//https://www.youtube.com/watch?v=eQMZ7cAPpAI
//https://www.youtube.com/watch?v=brFtzAF1vMw
public class PutRequest {
	@BeforeTest
	public void URISetUp() {
		RestAssured.baseURI="http://localhost:3000";
	}
	//ID would be same ,Data should be change
	@Test
	public void ReplaceData() {
		GetterSetter gs=new GetterSetter();
		
		gs.setFirstName("Areeb");
		gs.setLastName("Khan");
		gs.setEmail("khan1234@yahoo.com");
		RequestSpecification rs=RestAssured
				.given()
				.body(gs)
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.PUT, "/Student/4");
		System.out.println("Response body is : "+resp.asString());
	}


}
