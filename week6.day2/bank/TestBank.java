package tests.bank;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBank {

	public static String id;
	
	@BeforeMethod
	public void setUp()
	{
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api";
		RequestSpecification request =RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"username\": \"FebApiuser\",\r\n"
						+ "    \"password\": \"Eagle@123\"\r\n"
						+ "}");
		Response response =request.post("/users/login");
		id = response.jsonPath().get("id");
					
	}
	
	@Test
	public void testaccount()
	{
	
		RequestSpecification request =RestAssured.given().contentType(ContentType.JSON).header("authorization",id)
				.body("{\r\n"
						+ "    \"friendlyName\": \"TestProjectDayAccount\",\r\n"
						+ "    \"type\": \"savings\",\r\n"
						+ "    \"userId\": \"64290731ba9f8a0047adacfc\",\r\n"
						+ "    \"balance\": 100,\r\n"
						+ "    \"accountNumber\": 57164045\r\n"
						+ "}");
		Response response =request.post("/accounts");
		response.prettyPrint();
		
		
	}
}
