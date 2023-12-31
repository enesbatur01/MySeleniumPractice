package api.tests;

import api.baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestapi extends BaseUrlJsonPlaceholder {
    /*
        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
        edin
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve “title” degerinin
        “optio dolor molestias sit” oldugunu test edin
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
        null oldugunu test edin
     */




    @Test
    public void test01(){
        specJsonPlaceholder.pathParam("pp1","posts");

        Response response = given().when()
                        .spec(specJsonPlaceholder).get("/{pp1}");
        SoftAssert softAssert = new SoftAssert();

        response.then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.hasSize(100));
    }
    @Test
    public void test02(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",44);
        Response response = given().when().spec(specJsonPlaceholder).get("/{pp1}/{pp2}");
        response.then().assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }

    @Test
    public void test03(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",50);
        Response response = given().when().spec(specJsonPlaceholder).delete("/{pp1}/{pp2}");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.nullValue());



    }
}
