package week3.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostPutPatchIncidentsWithBodyAsString {
	
@Test(priority=0)
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
		Response response = inputRequest.post();	
		
		
    //Validate the response(with status code and response as string)
		response.prettyPrint();
}
	
	@Test(priority=1)
public void putInci()
{
    //Requirements
		
    //Endpoint with resources
		
		RestAssured.baseURI= "https://dev68818.service-now.com/api/now/table/incident/dfa991de4782611041cb93bd436d43d1";
		
    //Construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "\r\n"
						+ "\"short_description\":\"Updated\"\r\n"
						+ "\r\n"
						+ "}");
		
    //Send the request (http methods)
		Response response = inputRequest.put();
		
		
    //Validate the response(with status code and response as string)
		response.prettyPrint();
}

	@Test(priority=2)
	public void patchInci()
	{
	    //Requirements
			
	    //Endpoint with resources
			
			RestAssured.baseURI= "https://dev68818.service-now.com/api/now/table/incident/dfa991de4782611041cb93bd436d43d1";
			
	    //Construct the request (params, auth, etc)
			RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
			RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON)
					.body("{\r\n"
							+ "\r\n"
							+ "\"short_description\":\"Updated2\"\r\n"
							+ "\r\n"
							+ "}");
			
	    //Send the request (http methods)
			Response response = inputRequest.patch();
			
			
	    //Validate the response(with status code and response as string)
			response.prettyPrint();
	}
	
	
	
	@Test(priority=3)
	public void deleteInci()
	{
	    //Requirements
			
	    //Endpoint with resources
			
			RestAssured.baseURI= "https://dev68818.service-now.com/api/now/table/incident/dfa991de4782611041cb93bd436d43d1";
			
	    //Construct the request (params, auth, etc)
			RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
			RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON)
					.body("{\r\n"
							+ "\r\n"
							+ "\"short_description\":\"Updated2\"\r\n"
							+ "\r\n"
							+ "}");
			
	    //Send the request (http methods)
			Response response = inputRequest.delete();
			
			
	    //Validate the response(with status code and response as string)
			response.prettyPrint();
	}
	
	
	
	
	
	
}
