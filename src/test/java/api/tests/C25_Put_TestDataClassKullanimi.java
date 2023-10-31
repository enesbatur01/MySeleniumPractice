package api.tests;

import api.baseUrl.BaseUrlJsonPlaceholder;
import api.testData.TestDataJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    @Test
    public void test01(){

        /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         */

        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);

        /*
        Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
         */
        JSONObject requestBody = TestDataJsonPlaceholder.jsonBodyCreate(10,70,"Ahmet","Merhaba");
        JSONObject expectedData = TestDataJsonPlaceholder.jsonBodyCreate(10,70,"Ahmet","Merhaba");


        Response response = given().contentType(ContentType.JSON).when().spec(specJsonPlaceholder).body(requestBody.toString()).put("/{pp1}/{pp2}");
        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(response.statusCode(),TestDataJsonPlaceholder.succesStatusCode);
        assertEquals(response.contentType(),TestDataJsonPlaceholder.contentType);
        assertEquals(response.header("Connection"),TestDataJsonPlaceholder.connectionHeader);
        assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
        assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        assertEquals(expectedData.get("body"),responseJsonPath.get("body"));


    }



}
