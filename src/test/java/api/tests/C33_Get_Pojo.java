package api.tests;

import api.baseUrl.BaseUrlDummy;
import api.pojos.PojoDummyExampleData;
import api.pojos.PojoDummyExampleResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C33_Get_Pojo extends BaseUrlDummy {
    @Test
    public void test01(){

        specDummy.pathParams("pp1","employee","pp2",3);

        PojoDummyExampleData dataPojo = new PojoDummyExampleData(3,"Ashton Cox",86000,66,"");
        PojoDummyExampleResponse responseBody = new PojoDummyExampleResponse("success",dataPojo,"Successfully! Record has been fetched.");

        Response response = given().given().spec(specDummy).get("{pp1}/{pp2}");
        JsonPath responsePojo = response.jsonPath();
        Assert.assertEquals(responseBody.getStatus(),responsePojo.get("status"));
      Assert.assertEquals(responseBody.getMessage(),responsePojo.get("message"));
        Assert.assertEquals(responseBody.getData().getId(),responsePojo.get("data.id"));
        Assert.assertEquals(responseBody.getData().getEmployeeName(),responsePojo.get("data.employee_name"));
        Assert.assertEquals(responseBody.getData().getEmployeeSalary(),responsePojo.get("data.employee_salary"));
        Assert.assertEquals(responseBody.getData().getEmployeeAge(),responsePojo.get("data.employee_age"));
        Assert.assertEquals(responseBody.getData().getProfileImage(),responsePojo.get("data.profile_image"));




    }
}
