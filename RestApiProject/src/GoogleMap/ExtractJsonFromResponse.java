package GoogleMap;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExtractJsonFromResponse {
	@BeforeTest
	public void setBaseUri() {
		RestAssured.baseURI="http://maps.googleapi.com";
		//RestAssured.baseURI="http://www.restapi.demoqa.com/utilities";
	}
	@Test
	public void ExtarctJson() throws IOException {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON)
				.param("query", "Manhattan")
				.param("key","");
				
		Response resp=rs.request(Method.GET, "/maps/api/place/textsearch/json")
				.then()
				.extract().response();
		//Response resp=rs.request(Method.GET, "/books/getallbooks");
		
		System.out.println(resp.asString());
		File f=new File("C://ITTraining//Xmlformat");//from here code for write to another file
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(resp.asString());
		bw.newLine();
		bw.flush();
		
	
	 

}
}
