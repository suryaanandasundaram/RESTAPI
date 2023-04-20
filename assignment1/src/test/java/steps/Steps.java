package steps;

import org.hamcrest.Matchers;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Steps {
	
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
	
	@And("add {string} and {string}")
	public void addDescCategory(String desc,String category)
	{
		request =RestAssured.given().contentType(ContentType.JSON)
		.body("{\"short_description\":\"desc\",\"category\":\"category\"}");
	}
	@When("send the request")
	public void sendrequest()
	{
		response = request.post();
	}
	@Then("validate the response")
	public void validateResponse()
	{
		String desc = response.jsonPath().getString("result.short_description");
		if(desc.equalsIgnoreCase("This is First"))
		{
			response.then().assertThat().body("result.category",Matchers.equalTo("software") );
			response.then().log().all();
		}
		else if(desc.equalsIgnoreCase("This is Second"))
		{
			response.then().assertThat().body("result.category",Matchers.not("software") ).body("result.category",Matchers.not("inquiry") );
			response.then().log().all();
		}
		else
		{
			response.then().assertThat().body("result.short_description",Matchers.notNullValue() );
			response.then().log().all();
		}
		
	}

}
