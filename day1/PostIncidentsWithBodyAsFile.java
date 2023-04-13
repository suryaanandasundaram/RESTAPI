package week3.day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostIncidentsWithBodyAsFile {

	@Test
	public void putInci() {
		// Requirements

		// Endpoint with resources

		RestAssured.baseURI = "https://dev68818.service-now.com/api/now/table/change_request/52b5c3324702211041cb93bd436d4328";

		// Construct the request (params, auth, etc)

		File file = new File("./src/test/resources/data.json");

		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON).body(file);

		// Send the request (http methods)
		Response response = inputRequest.put();

		// Validate the response(with status code and response as string)
		response.prettyPrint();
		
	}
}
