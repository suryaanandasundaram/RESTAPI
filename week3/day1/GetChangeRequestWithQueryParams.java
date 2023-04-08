package week3.day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetChangeRequestWithQueryParams {

	
@Test	
public void getChangeRequest()
{
	  //Requirements
	
    //Endpoint with resources
		
		RestAssured.baseURI=("https://dev68818.service-now.com/api/now/table/change_request");
		
    //Construct the request (params, auth, etc)
		
		Map<String,String> data = new HashMap<String,String>();
		data.put("sysparm_fields", "sys_id,category");
		data.put("category", "hardware");
		
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		RequestSpecification input = RestAssured.given().queryParams(data);
		
    //Send the request (http methods)
		
		Response response = input.get();
    //Validate the response(with status code and response as string)
	   response.prettyPrint();
	
	
}
		
}
