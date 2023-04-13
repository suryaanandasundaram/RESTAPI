package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostIncidentsWithOutBody {
	
	@Test
public void postInci()
{
    //Requirements
		
    //Endpoint with resources
		
		RestAssured.baseURI= "https://dev68818.service-now.com/api/now/table/incident";
		
    //Construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON);
		
    //Send the request (http methods)
		Response response = inputRequest.post();	
		
		
    //Validate the response(with status code and response as string)
		response.prettyPrint();
}
}
