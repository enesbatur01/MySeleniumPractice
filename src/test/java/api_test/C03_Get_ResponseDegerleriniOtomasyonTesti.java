package api_test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniOtomasyonTesti {

    @Test
    public void testName() {

        int expectedStatusCode=200;
        String expectedContentType="application/json; charset=utf-8";
        String expectedserverName="Cowboy";
        String expectedStatusLine ="HTTP/1.1 200 OK";



        String url ="https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);


        response.then()
                .assertThat()
                .statusCode(expectedStatusCode)
                .contentType(expectedContentType)
                .header("Server",expectedserverName)
                .statusLine(expectedStatusLine);


    }
}
