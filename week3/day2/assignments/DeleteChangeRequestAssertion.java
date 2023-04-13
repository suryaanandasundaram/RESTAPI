package week3.day2.assignments;

import java.io.File;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteChangeRequestAssertion {
	
	@Test
	void deleteChangeRequest()
	{
		File file = new File("./src/test/resources/updateChangeRequest.json");
		
		RestAssured.baseURI= "https://dev68818.service-now.com/api/now/table/change_request/f204520b4702211041cb93bd436d43ac";
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON).body(file);
		
		Response res = input.delete();
		res.then().log().all().assertThat().statusLine("HTTP/1.1 204 No Content").statusCode(204);
		
	}



}
