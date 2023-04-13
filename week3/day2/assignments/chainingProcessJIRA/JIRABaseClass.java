package chainingProcessJIRA;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JIRABaseClass {

	public static RequestSpecification request =null;
	public static String issueId= null;
	public static Response res=null;
	public String apiKey = "ATATT3xFfGF0IMd8pgWuk5LYmfZGIH9JOAn7KPWEHQYD0ghXXNvK0i9L6UJagPlivbaDXkZg5QAcRRwVhpq5AmjM7pF-cYMw9bekiiA1pNRmIKjK2WOYTY8FfQ8mzAPNSlFqCWgOwfNthhf2FjA0TBJLN4vDnohYB-udJrO8efJSndB2b2tqHcE=60D879A6";
	
	
	@BeforeMethod
	public void beforeMethod()
	
	{
		RestAssured.baseURI = "https://suryaprabha.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication =RestAssured.preemptive().basic("suryaanandasundaram@gmail.com",apiKey);
	    request= RestAssured.given().contentType(ContentType.JSON).log().all();
	    
	}
	
	@AfterMethod
	public void afterMethod()
	{
		res.then().log().all();
	}
	
	
	
}
