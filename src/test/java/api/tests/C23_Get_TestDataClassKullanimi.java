package api.tests;

import api.baseUrl.BaseUrlJsonPlaceholder;
import api.testData.TestDataJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    @Test
    public void test(){

/*
https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
 */
        specJsonPlaceholder.pathParams("pp1","posts","pp2",22);

        Response response = given().when().spec(specJsonPlaceholder).get("/{pp1}/{pp2}");

        JSONObject expectedData = TestDataJsonPlaceholder.responseBodyCreate22();
        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(TestDataJsonPlaceholder.succesStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));

    }

}
