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

public class TC004_CreateAccount extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new TestBank Account (REST)";
		testDescription = "Create a new Account";
		nodes = "TestBank";
		authors = "Surya";
		category = "REST";
		//dataProvider
		dataFileName = "TC004";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void createAccount(File file) {		
				
		Response response = postWithBodyAsFileAndUrlAuth(file, "/accounts",id);
		response.prettyPrint();
		verifyContentType(response, "application/json");
		
		verifyResponseCode(response, 200);
			
		verifyContentWithKey(response, "friendlyName", "TestProjectDayAccount");
		
	}


}


