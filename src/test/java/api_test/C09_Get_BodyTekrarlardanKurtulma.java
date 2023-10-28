package api_test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_BodyTekrarlardanKurtulma {
    @Test
    public void testName() {

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
        donen Response’un,
        status code’unun 200,
        ve content type’inin application-json,
        ve response body’sindeki
        "firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
         */
        String url = "https://restful-booker.herokuapp.com/booking/11";
        Response response = given().when().get(url);
        /* 1. yol tekrarlı önerilmez
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Josh"))
                .body("lastname", Matchers.equalTo("Allen"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid", Matchers.equalTo(true))
                .body("additionalneeds",Matchers.notNullValue());
        */

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Josh"),
                        "lastname",equalTo("Allen"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(true),
                        "additionalneeds",notNullValue());

    }
}
