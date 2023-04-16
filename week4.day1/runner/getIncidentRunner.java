package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features="src/test/java/features/getIncidentsDescriptionAndCategory.feature",
		glue="steps",
		monochrome =true
		)

public class getIncidentRunner extends AbstractTestNGCucumberTests
{

}
