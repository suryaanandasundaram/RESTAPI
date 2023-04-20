package steps;

import org.hamcrest.Matchers;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Steps {
	
	public static RequestSpecification request = null;
	public static Response response = null;
	public static String sys_id = null;
	public static String randomStr = null;
	
	
	@Given("set the endpoint")
	public void setEndPoint()
	{
		RestAssured.baseURI = "https://dev87474.service-now.com/api/now/table/incident";
	}
	@And("add the authentication")
	public void addAuth()
	{
		RestAssured.authentication = RestAssured.basic("admin", "$hrNBO$1g6aD");
	}
	
	@And("add {string} and {string}")
	public void addDescCategory(String desc,String category)
	{
		request =RestAssured.given().contentType(ContentType.JSON)
				.body("{\"short_description\":\"" + desc + "\",\"category\":\"" + category + "\"}");
	}
	@When("send the request for create")
	public void postrequest()
	{
		response = request.post();
		sys_id =response.jsonPath().get("result.sys_id");
		System.out.println("***********"+sys_id);
	}
	
	@And("update RandomString as description")
	public void addRandomString()
	{
		System.out.println("***********"+sys_id);
		randomStr = RandomStringUtils.randomAlphanumeric(6);
		request =RestAssured.given().contentType(ContentType.JSON)
		.body("{\"short_description\":\"" + randomStr + "\"}");
	}
	@When("send the request for update")
	public void putrequest()
	{
		response = request.put("/"+sys_id);
		
	}
	
	@Then("validate the response of create Incident")
	public void validateCreateResponse()
	{
		response.then().assertThat().statusCode(201).log().all();
		response.then().assertThat().body("result.task_effective_number",Matchers.hasLength(10));
		
		
	}
	@Then("validate the response of update Incident")
	public void validateUpdateResponse()
	{
		response.then().assertThat().statusCode(200).log().all();
		response.then().assertThat().body("result.task_effective_number",Matchers.hasLength(10));
		response.then().assertThat().body("result.short_description",Matchers.matchesPattern("^[a-zA-Z0-9]{6}$"));
	
		
		
	}
	
	@When("send the request for delete")
	public void deleteRequest()
	{
		System.out.println("***********"+sys_id);
		response = request.delete("/"+sys_id);
			
	}
	
	@Then("validate the response of delete Incident")
	public void validateDeleteResponse()
	{
		response.then().assertThat().statusCode(204).log().all();
		response.then().assertThat().statusLine("HTTP/1.1 204 No Content");
	}
	
	@And("validate the record is removed")
	public void validateRemove()
	{
		response = request.get("/"+sys_id);
		response.then().assertThat().statusCode(404).log().all();
		response.then().assertThat().body("error.message",Matchers.containsStringIgnoringCase("No Record found"));
	}
	
	@Then("validate the response of create Incident fields")
	public void dataTablemethod(DataTable dt)
	{
		Map<String, String> map = dt.asMap();
		
		for (Entry<String, String> eachEntry: map.entrySet())
		{
			response.then().body(eachEntry.getKey(),Matchers.containsStringIgnoringCase(eachEntry.getValue()));
		}
	}

}
