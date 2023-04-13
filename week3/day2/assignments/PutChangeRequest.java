package week3.day2.assignments;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutChangeRequest {
	
	@Test
	void putChangeRequest()
	{
		File file = new File("./src/test/resources/updateChangeRequest.json");
		
		RestAssured.baseURI= "https://dev68818.service-now.com/api/now/table/change_request/52b5c3324702211041cb93bd436d4328";
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON).body(file).log().all();
		
		Response res = input.put();
		res.then().log().all().assertThat().body("result.short_description",Matchers.containsString("using put method for hamcrest")).statusCode(200);
		
	}



}
