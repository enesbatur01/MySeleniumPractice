package api.tests;

import api.baseUrl.BaseUrlDummy;
import api.testData.TestDataDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C26_Get_TestDataKullanimi extends BaseUrlDummy {
    /*
    https://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
donen response’un status code’unun 200, content Type’inin application/json ve body’sinin
asagidaki gibi oldugunu test edin
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
    @Test
    public void test(){
        specDummy.pathParams("pp1","employee","pp2",3);

        JSONObject expectedData = TestDataDummy.jsonResponseBodyCreate(3,"Ashton Cox",86000,66);

        Response response = given().when().spec(specDummy).get("/{pp1}/{pp2}");

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(TestDataDummy.succesStatusCode,response.statusCode());
        Assert.assertEquals(TestDataDummy.contentType,response.contentType());
        Assert.assertEquals(expectedData.get("status"),responseJsonPath.get("status"));
        Assert.assertEquals(expectedData.get("message"),responseJsonPath.get("message"));
        Assert.assertEquals(expectedData.getJSONObject("data").get("id"),responseJsonPath.get("data.id"));
        Assert.assertEquals(expectedData.getJSONObject("data").get("employee_name"),responseJsonPath.get("data.employee_name"));
        Assert.assertEquals(expectedData.getJSONObject("data").get("employee_salary"),responseJsonPath.get("data.employee_salary"));
        Assert.assertEquals(expectedData.getJSONObject("data").get("employee_age"),responseJsonPath.get("data.employee_age"));
        Assert.assertEquals(expectedData.getJSONObject("data").get("profile_image"),responseJsonPath.get("data.profile_image"));



    }
}
