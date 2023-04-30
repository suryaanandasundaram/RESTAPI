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

public class TC006_ApplyTransactions extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Apply Transactions in TestBank Account (REST)";
		testDescription = "Apply Transactions Testing";
		nodes = "TestBank";
		authors = "Surya";
		category = "REST";
		//dataProvider
		dataFileName = "TC006";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void applyTransactions(File file) {		
				
		Response response = postWithBodyAsFileAndUrlAuth(file, "/transactions",id);
		response.prettyPrint();
		verifyContentType(response, "application/json");
		
		verifyResponseCode(response, 200);
			
		
		
	}


}


