package chainingProcessServiceNow;

import org.testng.annotations.Test;



public class CreateIncident extends BaseClass

{
    @Test
	public void createIncident()
	{
    	res = input.post("incident");
    	sysid = res.jsonPath().get("result.sys_id");
    	System.out.println("Generated System Id =>"+sysid);
    	res.then().assertThat().statusCode(201);
	}
}
