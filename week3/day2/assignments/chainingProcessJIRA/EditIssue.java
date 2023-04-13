package chainingProcessJIRA;

import org.testng.annotations.Test;



public class EditIssue extends JIRABaseClass {

	@Test (dependsOnMethods = {"chainingProcessJIRA.CreateIssue.createIssue"})
	public void editIssue()
	{
		request.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "\r\n"
				+ "        \"description\": \"Bug creation Using REST API for testing\"\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ ")");
		res = request.put(issueId);
		res.then().assertThat().statusCode(204);
		System.out.println("Status Line"+res.statusLine());
	}
}
