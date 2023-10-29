package api.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {
    @Test
    public void test(){
    /*
    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
    request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
    Request Body
    {
    "status": "success",
    "data": {
    "name": “Ahmet",
    "salary": "1230",
    "age": "44",
    "id": 40
    }
    }
    Response Body
    { "status": "success",
        "data": {
            "status": "success",
            "data": {
                "name": “Ahmet",
                "salary": "1230",
                "age": "44",
                "id": 40 }
             },
    "message": "Successfully! Record has been updated."}
     */
        String  url ="https://dummy.restapiexample.com/api/v1/update/21";
        JSONObject requestBody = new JSONObject();
        JSONObject dataInformationJson= new JSONObject();
        JSONObject expectedData = new JSONObject();
        dataInformationJson.put("name","Ahmet");
        dataInformationJson.put("salary","1230");
        dataInformationJson.put("age","44");
        dataInformationJson.put("id",40);
        requestBody.put("status","success");
        requestBody.put("data",dataInformationJson);

        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Successfully! Record has been updated.");

        Response response = given().contentType(ContentType.JSON).when().body(requestBody.toString()).put(url);

        JsonPath responseJsonPath = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expectedData.get("status"),responseJsonPath.get("status"));
        softAssert.assertEquals(expectedData.get("message"),responseJsonPath.get("message"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("status"),responseJsonPath.get("data.status"));
        softAssert.assertEquals(expectedData.getJSONObject("data").getJSONObject("data").get("name"),responseJsonPath.get("data.data.name"));
        softAssert.assertEquals(expectedData.getJSONObject("data").getJSONObject("data").get("salary"),responseJsonPath.get("data.data.salary"));
        softAssert.assertEquals(expectedData.getJSONObject("data").getJSONObject("data").get("age"),responseJsonPath.get("data.data.age"));
        softAssert.assertEquals(expectedData.getJSONObject("data").getJSONObject("data").get("id"),responseJsonPath.get("data.data.id"));
        softAssert.assertAll();


    }
}
