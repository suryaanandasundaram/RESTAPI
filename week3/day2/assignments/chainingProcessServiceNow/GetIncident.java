package chainingProcessServiceNow;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetIncident extends BaseClass
{

 @Test(dependsOnMethods= {"chainingProcessServiceNow.CreateIncident.createIncident"})
 public void getIncident()
 {
	 Response res = input.get("incident/"+sysid);
	 System.out.println( res.statusLine());
	 res.then().assertThat().statusCode(200);
 }
}
