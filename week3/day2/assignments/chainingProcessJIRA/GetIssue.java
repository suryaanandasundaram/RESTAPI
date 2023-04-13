package chainingProcessJIRA;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;



public class GetIssue extends JIRABaseClass {

	@Test (dependsOnMethods = {"chainingProcessJIRA.EditIssue.editIssue"})
	public void getIssue()
	{
		
		res = request.get(issueId);
		res.then().assertThat().statusCode(200);
		res.then().body("fields.description",Matchers.containsString("Bug creation Using REST API for testing"));
	}
}
