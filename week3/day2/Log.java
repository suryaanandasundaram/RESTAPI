package week3.day2;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Log {

	
@Test	
public void postChangeRequest()
{
	  //Requirements
	
    //Endpoint with resources
		
		RestAssured.baseURI=("https://dev68818.service-now.com/api/now/table/change_request");
		
    //Construct the request (params, auth, etc)
		
		
		
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "\r\n"
						+ "\"description\":\"My first test with Rest Assured\",\r\n"
						+ "\"short_description\":\"Success\"\r\n"
						+ "\r\n"
						+ "}").log().all();
		
    //Send the request (http methods)
		
		Response response = input.post();
    //Validate the response(with status code and response as string)
	   response.then().log().all();
	
	
}
		
}
