package chainingProcessServiceNow;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteIncident extends BaseClass

{
 @Test(dependsOnMethods= {"chainingProcessServiceNow.EditIncident.editIncident"})
 public void deletIncident()
 {
	 Response res = input.delete("incident/"+sysid);
	 System.out.println( res.statusLine());
	 res.then().assertThat().statusCode(204);
 }
}
