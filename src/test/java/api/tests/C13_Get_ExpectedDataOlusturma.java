package api.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {
    @Test
    public void test(){

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
            yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
            Response body :
            {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
            um mollitia molestiae aut atque rem suscipitnam impedit esse"
            }
         */
    String url = "https://jsonplaceholder.typicode.com/posts/22";
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("userId",3);
        expectedBody.put("id",22);
        expectedBody.put("title","dolor sint quo a velit explicabo quia nam");
        expectedBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        Response response= given().when().get(url);


        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedBody.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedBody.get("userId"),responseJsonPath.get("userId"));
        Assert.assertEquals(expectedBody.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedBody.get("body"),responseJsonPath.get("body"));



    }
}
