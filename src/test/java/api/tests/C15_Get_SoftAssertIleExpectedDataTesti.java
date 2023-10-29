package api.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {
    @Test
    public void test(){
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status": "success",
        "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
        },
        "message": "Successfully! Record has been fetched."
        }
         */
        String url="http://dummy.restapiexample.com/api/v1/employee/3";
        SoftAssert softAssert = new SoftAssert();
        JSONObject expectedData= new JSONObject();
        JSONObject dataObj= new JSONObject();
        dataObj.put("id",3);
        dataObj.put("employee_name","Ashton Cox");
        dataObj.put("employee_salary",86000);
        dataObj.put("employee_age",66);
        dataObj.put("profile_image","");
        expectedData.put("status","success");
        expectedData.put("data",dataObj);
        expectedData.put("message","Successfully! Record has been fetched.");


        Response response= given().when().get(url);
        JsonPath responseJsonPath = response.jsonPath();

        softAssert.assertEquals(expectedData.get("status"),responseJsonPath.get("status"));
        softAssert.assertEquals(expectedData.get("message"),responseJsonPath.get("message"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("id"),responseJsonPath.get("data.id"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("employee_name"),responseJsonPath.get("data.employee_name"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("employee_salary"),responseJsonPath.get("data.employee_salary"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("employee_age"),responseJsonPath.get("data.employee_age"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("profile_image"),responseJsonPath.get("data.profile_image"));
        softAssert.assertAll();


    }
}
