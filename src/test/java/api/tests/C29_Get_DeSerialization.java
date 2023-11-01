package api.tests;

import api.baseUrl.BaseUrlDummy;
import api.testData.TestDataDummy;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C29_Get_DeSerialization extends BaseUrlDummy {
    @Test
    public void test01(){
    specDummy.pathParams("pp1","employee","pp2",3);

        Map<String,Object> expectedData = TestDataDummy.mapBodyCreate();

        Response response = given().when().spec(specDummy).get("{pp1}/{pp2}");

        Map<String,Object> responseGson =response.as(Map.class);

        Assert.assertEquals(TestDataDummy.succesStatusCode,response.statusCode());
        Assert.assertEquals(TestDataDummy.contentType,response.contentType());
        Assert.assertEquals(expectedData.get("status"),responseGson.get("status"));
        Assert.assertEquals(expectedData.get("message"),responseGson.get("message"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("profile_image"),((Map)responseGson.get("data")).get("profile_image"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("id"),((Map)responseGson.get("data")).get("id"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_name"),((Map)responseGson.get("data")).get("employee_name"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_salary"),((Map)responseGson.get("data")).get("employee_salary"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_age"),((Map)responseGson.get("data")).get("employee_age"));


    }
}
