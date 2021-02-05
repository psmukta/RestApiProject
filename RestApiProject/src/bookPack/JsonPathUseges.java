package bookPack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pack2.Student;

public class JsonPathUseges {
	@BeforeTest
	public void URISetUp() {
		
		RestAssured.baseURI="http://restapi.demoqa.com";
	}
	//@Test
	public void GetRequest() throws IOException {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response resp=rs.request(Method.GET, "/utilities/books/getallbooks");
		System.out.println("Response body is : "+resp.asString());
		File f=new File("C://ITTraining//Xmlformat");//from here code for write to another file
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(resp.asString());
		bw.newLine();
		bw.flush();
	
	 }
	@Test 
	public void JsonPathTest() {
		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
	Response resp=rs.request(Method.GET, "/utilities/books/getallbooks");
	
	JsonPath jsp=resp.jsonPath();//to get all response body value
	List<Book>allBooks=jsp.getList("books", Book.class);
	for(Book book:allBooks) {
		//System.out.println("Isbn is : "+book.isbn);
		//System.out.println("Author  is : "+book.author);
		System.out.println("Title  is : "+book.title);
		System.out.println("Pages is : "+book.pages);
	}
}
}
