package Services;

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
	public void URIsetup() {
		RestAssured.baseURI="http://services.groupkt.com/country/get/iso2code/CA";
		//RestAssured.basePath="/country/get/iso2code/CA";
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
	public void JsonPathTest() {
		RequestSpecification rs= RestAssured
			.given()
			.body("")
			.when()
			.contentType(ContentType.JSON);
			Response resp=rs.request(Method.GET,"");
			JsonPath jsp=resp.jsonPath();
			System.out.println("Message is " +jsp.get("message"));
			System.out.println("Result is " +jsp.get("result"));
			System.out.println("Name is " +jsp.get("name"));
			
			
			
	}

}
