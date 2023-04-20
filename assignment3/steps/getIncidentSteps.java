package steps;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getIncidentSteps {
	
	public RequestSpecification request = null;
	public Response response = null;
	
	@Given("set the endpoint")
	public void setEndPoint()
	{
		RestAssured.baseURI ="https://dev68818.service-now.com/api/now/table/incident";
	}
	@And("add the authentication")
	public void addAuth()
	{
		RestAssured.authentication = RestAssured.basic("admin", "hXB/1JMe+6ct");
	}
    @When("send the request")
	public void sendRequest()
	{
		request = RestAssured.given().log().all();
		response= request.get();
	}
	@Then("validate the response")
	public void validateResponse()
	{
		response.then().assertThat().statusCode(200).log().all();
	}
	
	@And ("add the queryParam {string} as {string}")
	public void setQueryParams(String key,String value)
	{
		request = RestAssured.given().log().all().queryParam(key, value);
	}
	@When("send the request with QP")
	public void sendRequestWithQP()
	{
		response =request.get();
	}
	@And ("add the queryParams")
	public void addQueryParams(DataTable dt)
	{
		Map<String, String> mapValues = dt.asMap();
		request = RestAssured.given().log().all().queryParams(mapValues);
	}
	
}
