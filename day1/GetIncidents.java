package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidents {
	
	@Test
public void getInci()
{
    //Requirements
		
    //Endpoint with resources
		
		RestAssured.baseURI= "https://dev68818.service-now.com/api/now/table/incident";
		
    //Construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		
    //Send the request (http methods)
		Response response = RestAssured.get();	
		
		
    //Validate the response(with status code and response as string)
		response.prettyPrint();
}
}
