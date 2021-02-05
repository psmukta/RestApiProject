package Ergast;

import java.util.List;

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
		RestAssured.baseURI="http://ergast.com"; 
		RestAssured.basePath="/api/f1/current.json";
	}
	//@Test
	public void GetRequest() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.XML);
		Response resp=rs.request(Method.GET,"" );
		System.out.println("Response body is : "+resp.asString());

	}
	@Test
	public void JsonPathUsegesTest() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.GET,"" );
		JsonPath jsp=resp.jsonPath();
		List<Ergast>RaceTable=jsp.getList("season.Races", Ergast.class);
		for(Ergast ergast:RaceTable) {
			System.out.println("RaceName  is : "+ergast.Races);
			//System.out.println("Locality is : "+ergast.Locality);
		}

	}


}
