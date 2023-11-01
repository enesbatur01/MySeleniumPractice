package api.tests;

import api.baseUrl.BaseUrlHerokuapp;
import api.testData.TestDataHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C30_Post_Deserialization extends BaseUrlHerokuapp {

    @Test
    public void test01(){
        specHerokuapp.pathParam("pp1","booking");
        Map<String,Object> requestBody = TestDataHerokuapp.mapRequestBodyCreate();
        Map<String,Object> expectedData = TestDataHerokuapp.mapResponseBodyCreate();
        Response response = given().contentType(ContentType.JSON).when().spec(specHerokuapp).body(requestBody).post("{pp1}");

        Map<String,Object> responseMap = response.as(Map.class);

        Assert.assertEquals(((Map)expectedData.get("booking")).get("firstname"), ((Map) responseMap.get("booking")).get("firstname"));
        Assert.assertEquals(((Map)expectedData.get("booking")).get("lastname"), ((Map) responseMap.get("booking")).get("lastname"));
        Assert.assertEquals(((Map)expectedData.get("booking")).get("totalprice"), ((Map) responseMap.get("booking")).get("totalprice"));
        Assert.assertEquals(((Map)expectedData.get("booking")).get("depositpaid"), ((Map) responseMap.get("booking")).get("depositpaid"));
        Assert.assertEquals(((Map)expectedData.get("booking")).get("additionalneeds"), ((Map) responseMap.get("booking")).get("additionalneeds"));
        Assert.assertEquals(((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkin"),((Map) ((Map) responseMap.get("booking")).get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkout"),((Map) ((Map) responseMap.get("booking")).get("bookingdates")).get("checkout"));



    }
}
