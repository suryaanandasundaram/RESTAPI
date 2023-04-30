package tests.rest;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lib.rest.RESTAssuredBase;

public class TC005_ApplyLoan extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Apply Loan in TestBank Account (REST)";
		testDescription = "Apply Loan Testing";
		nodes = "TestBank";
		authors = "Surya";
		category = "REST";
		//dataProvider
		dataFileName = "TC005";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void applyLoan(File file) {		
				
		Response response = postWithBodyAsFileAndUrl(file, "/quotes/newquote");
		response.prettyPrint();
		verifyContentType(response, "application/json");
		
		verifyResponseCode(response, 200);
			
		
		
	}


}


