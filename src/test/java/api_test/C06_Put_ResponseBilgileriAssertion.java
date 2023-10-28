package api_test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_ResponseBilgileriAssertion {
    @Test
    public void test(){

        /*
                https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
        PUT request gonderdigimizde
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }
        donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin cloudflare,
        ve status Line’in HTTP/1.1 200 OK
         */

        JSONObject body=new JSONObject();
        body.put("title","Ahmet");
        body.put("body","Merhaba");
        body.put("userId",10);
        body.put("id",70);

        int expectedStatus=200;
        String expectedContentType ="application/json; charset=utf-8";
        String expectedServer="cloudflare";
        String expectedStatusLine="HTTP/1.1 200 OK";

        String url="https://jsonplaceholder.typicode.com/posts/70";

        Response response = given().contentType(ContentType.JSON).when().body(body.toString()).put(url);

        response.then().assertThat().statusCode(expectedStatus).contentType(expectedContentType).header("Server",expectedServer).statusLine(expectedStatusLine);



    }
}
