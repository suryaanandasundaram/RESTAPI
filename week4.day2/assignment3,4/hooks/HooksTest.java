package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class HooksTest {

	@Before
	public void before()
	{
		RestAssured.baseURI = "https://dev77804.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "GXUu1kh8Jv%!");
	}
}
