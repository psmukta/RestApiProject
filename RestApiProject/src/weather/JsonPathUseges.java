package weather;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonPathUseges {
	@BeforeTest
	public void URIsetup() {
		RestAssured.baseURI="http://www.restapi.demoqa.com/utilities/weather/city";
		
	}
	//@Test
		public void GetRequest() {
			RequestSpecification rs=RestAssured
					.given()
					.body("")
					.when()
					.contentType(ContentType.JSON);
			Response resp=rs.request(Method.GET, "/randolph");
			System.out.println("Response body is : "+resp.asString());
		
		 }
	@Test
	public void JsonPathTest() {
		RequestSpecification rs= RestAssured
			.given()
			.body("")
			.when()
			.contentType(ContentType.JSON);
			Response resp=rs.request(Method.GET,"/randolph");
			JsonPath jsp=resp.jsonPath();
			System.out.println("Temperature is " +jsp.get("Temperature"));
			System.out.println("Humidity is " +jsp.get("Humidity"));
			System.out.println("WindSpeed is " +jsp.get("WindSpeed"));
			System.out.println("City is " +jsp.get("City"));
			
			
	}


}
