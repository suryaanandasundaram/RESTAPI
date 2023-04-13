package chainingProcessJIRA;

import org.testng.annotations.Test;



public class DeleteIssue extends JIRABaseClass {

	@Test (dependsOnMethods = {"chainingProcessJIRA.GetIssue.getIssue"})
	public void deleteIssue()
	{
		
		res = request.delete(issueId);
		res.then().assertThat().statusCode(204);
		res.then().assertThat().statusLine("HTTP/1.1 204 No Content");
	}
}
