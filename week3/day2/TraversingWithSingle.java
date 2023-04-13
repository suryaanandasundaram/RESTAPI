package week3.day2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TraversingWithSingle {
	
	@Test
public void postInci()
{
    //Requirements
		
    //Endpoint with resources
		
		RestAssured.baseURI= "https://dev68818.service-now.com/api/now/table/incident";
		
    //Construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "\r\n"
						+ "\"short_description\":\"Success\"\r\n"
						+ "\r\n"
						+ "}");
		
    //Send the request (http methods)
		Response response = inputRequest.get();
		 
		
    //Validate the response(with status code and response as string)
	List list = response.jsonPath().get("result.sys_id");
	
	
	
	System.out.println("List Size =>" +list.size());
		System.out.println("First System Id =>" +response.jsonPath().get("result[0].sys_id"));
}
}
