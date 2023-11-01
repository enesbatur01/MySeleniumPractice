package api.tests;

import api.baseUrl.BaseUrlJsonPlaceholder;
import api.testData.TestDataJsonPlaceholder;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C28_Put_DeSerialization extends BaseUrlJsonPlaceholder {
    @Test
    public void test01(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);
        Map<String,Object> requestBody = TestDataJsonPlaceholder.mapBodyCreate("Ahmet","Merhaba",10.0,70.0);
        Map<String,Object> expectedData = TestDataJsonPlaceholder.mapBodyCreate("Ahmet","Merhaba",10,70);

        Response response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON).when().body(requestBody).put("{pp1}/{pp2}");
        Map<String,Object> responseMap = response.as(HashMap.class);
        Assert.assertEquals(expectedData.get("title"),responseMap.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseMap.get("body"));
        Assert.assertEquals(expectedData.get("userId"),responseMap.get("userId"));
        Assert.assertEquals(expectedData.get("id"),responseMap.get("id"));


    }
}
