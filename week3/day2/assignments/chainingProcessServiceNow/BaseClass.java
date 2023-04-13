package chainingProcessServiceNow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static RequestSpecification input = null;
	public static String sysid = null;
	public static Response res = null;

	@BeforeMethod
	public void beforemethod()
	{
		RestAssured.baseURI ="https://dev68818.service-now.com/api/now/table/issue";
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
		input = RestAssured.given().contentType(ContentType.JSON).log().all();
	
	}
	@AfterMethod
	public void aftermethod()
	{
		res.then().log().all();
	}
}
