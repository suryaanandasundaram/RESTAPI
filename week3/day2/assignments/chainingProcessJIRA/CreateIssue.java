package chainingProcessJIRA;



import org.testng.annotations.Test;


public class CreateIssue extends JIRABaseClass{
    
	@Test
	public void createIssue()
	{
		request.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "    \"project\":\r\n"
				+ "                {\r\n"
				+ "                    \"key\": \"MAR\"\r\n"
				+ "                },\r\n"
				+ "    \"summary\": \"create issue in RA project\",\r\n"
				+ "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "                    \"name\": \"Bug\"\r\n"
				+ "                }\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ ")");
		res = request.post();
		issueId = res.jsonPath().get("id");
		System.out.println("Issue Id =>"+issueId);
		
		res.then().assertThat().statusCode(201);
	}
}
