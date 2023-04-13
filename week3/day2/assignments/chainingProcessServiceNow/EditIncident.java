package chainingProcessServiceNow;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class EditIncident extends BaseClass

{
 @Test(dependsOnMethods= {"chainingProcessServiceNow.GetIncident.getIncident"})
 public void editIncident()
 {
	 File file = new File("./src/test/resources/updateChangeRequest.json");
	 
	 input= input.body(file);
	 Response res = input.put("incident/"+sysid);
	 System.out.println( res.statusLine());
	 res.then().body("result.short_description",Matchers.containsString("using put method for hamcrest")).assertThat().statusCode(200);
	 
 }
}
