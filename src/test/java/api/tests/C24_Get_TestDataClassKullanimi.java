package api.tests;

import api.baseUrl.BaseUrlJsonPlaceholder;
import api.testData.TestDataJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C24_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {


    @Test
    public void test01(){

        /*
        response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
        ediniz
        Response body :
        {
        "userId": 4,
        "id": 40,
        "title": "enim quo cumque",
        "body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitiaquas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
        }
         */

        specJsonPlaceholder.pathParams("pp1","posts","pp2",40);

        JSONObject expectedData = TestDataJsonPlaceholder.jsonBodyCreate(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");

        Response response = given().when().spec(specJsonPlaceholder).get("/{pp1}/{pp2}");

        JsonPath responseJsonPath = response.jsonPath();

        response.prettyPrint();
        assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
        assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        assertEquals(expectedData.get("body"),responseJsonPath.get("body"));
    }
}
