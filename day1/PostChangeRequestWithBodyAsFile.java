package week3.day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostChangeRequestWithBodyAsFile {
	
	@Test
	public void postChangeRequest()
	{
		File file = new File("./src/test/resources/createChangeRequest.json");
//		 Step 1:Requirements 
//		 Step 2:Endpoint with resources
		RestAssured.baseURI = "https://dev68818.service-now.com/api/now/table/change_request";
//		 Step 3:Construct the request (params, auth, etc)
		
		
		
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON).body(file);
		
//		 Step 4:Send the request (http methods)
		
		Response response = input.post();
		
		
//		 Step 5:Validate the response(with status code and response as string)
		response.prettyPrint();
	}

}
