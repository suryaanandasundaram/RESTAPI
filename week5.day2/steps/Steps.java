package steps;

import java.io.File;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.asserts.SoftAssert;

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
	
	public RequestSpecification request = null;
	public Response response = null;
	public Response[] res =null;
	public int i=0;
	public int j=0;
	
	
	@Given("set the endpoint")
	public void setEndPoint()
	{
		RestAssured.baseURI ="https://dev85087.service-now.com/api/now/table/incident";
	}
	@And("add the authentication")
	public void addAuth()
	{
		RestAssured.authentication = RestAssured.basic("admin", "ecnWUM*1$T3s");
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
	@When("pass the file and send the request")
	public void pass(DataTable dt)
	{
	   
		List<String> list= dt.asList();
	   
	    res = new Response[list.size()] ;
	    
	    System.out.println("list Size" +list.size());
	   
		for(String filelocation:list)	
		{
			
			File file =new File(filelocation);
			request = RestAssured.given().contentType(ContentType.JSON).body(file);
			res[i] = request.post();
			i=i+1;		
			
		}
		
		j=i-1;	
		
	}
	@Then("validate the response of create")
	public void validate()
	{ 
		i=0;
		while(i<=j)
		{
		res[i].then().assertThat().body("result.category",Matchers.notNullValue() );
		res[i].then().log().all();
		i++;
		
		}
		
	}
	@Then("validate the response of createIncident")
	public void validatemethod()
	{
		response.then().assertThat().body("result.number", Matchers.containsString("INC"),"result",Matchers.hasKey("correlation_id")).log().ifValidationFails();
	   
	}
	

}
