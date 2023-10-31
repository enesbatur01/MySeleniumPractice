package api.tests;

import api.baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        /*
        1- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
            yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test edecek bir GET
            request gonderdigimizde, donen response’un status code’unun 200 oldugunu ve “Eric”
            ismine sahip en az bir booking oldugunu test edin
         */
        specHerokuapp.pathParam("pp1","booking")
                .queryParam("firstname","Eric");
        Response response = given().when().spec(specHerokuapp).get("/{pp1}");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.notNullValue());
    }

    @Test
    public void test02(){
       /*
       - https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
        yazarak “firstname” degeri “Susan” ve “lastname” degeri “Smith” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un status
        code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir booking oldugunu test
        edin
        */
        specHerokuapp.pathParam("pp1","booking").queryParams("firstname","Susan","lastname","Smith");

        Response response = given().when().spec(specHerokuapp).get("/{pp1}");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid",Matchers.notNullValue());

    }
}
