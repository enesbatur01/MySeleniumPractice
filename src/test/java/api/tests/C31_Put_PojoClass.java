package api.tests;

import api.baseUrl.BaseUrlJsonPlaceholder;
import api.pojos.PojoJsonPlaceholder;
import api.testData.TestDataJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {
    @Test
    public void test01(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);

        PojoJsonPlaceholder requestBody = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);
        PojoJsonPlaceholder expectedData = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        Response response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON).when().body(requestBody).put("{pp1}/{pp2}");
        PojoJsonPlaceholder responsePojo = response.as(PojoJsonPlaceholder.class);

        Assert.assertEquals(TestDataJsonPlaceholder.succesStatusCode,response.statusCode());
        Assert.assertEquals(TestDataJsonPlaceholder.connectionHeader,response.header("Connection"));
        Assert.assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        Assert.assertEquals(expectedData.getBody(),responsePojo.getBody());
        Assert.assertEquals(expectedData.getTitle(),responsePojo.getTitle());
        Assert.assertEquals(expectedData.getUserId(),responsePojo.getUserId());
        Assert.assertEquals(expectedData.getId(),responsePojo.getId());

    }
}
