package api_test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_Post_JsonPathIleBodyTesti {

    @Test
    public void testName() {

    /*
                https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
                gonderdigimizde
                {
                "firstname" : "Ahmet",
                "lastname" : “Bulut",
                "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
                "checkin" : "2023-01-10",
                "checkout" : "2023-01-20"
                },
                "additionalneeds" : "wi-fi"
}
                donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                "firstname“in,"Ahmet",
                ve "lastname“in, "Bulut",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2023-01-10
                ve "checkout" tarihinin 2023-01-20
                ve "additionalneeds“in,"wi-fi"
                oldugunu test edin
     */
            String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject dateJsonObj= new JSONObject();
        JSONObject body = new JSONObject();
        dateJsonObj.put("checkin","2023-01-10");
        dateJsonObj.put("checkout","2023-01-20");
        body.put("firstname","Ahmet");
        body.put("lastname","Bulut");
        body.put("totalprice",500);
        body.put("depositpaid",false);
        body.put("bookingdates",dateJsonObj);
        body.put("additionalneeds","wi-fi");

        Response response = given().contentType(ContentType.JSON).when().body(body.toString()).post(url);

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname",equalTo("Ahmet"),
                        "booking.lastname",equalTo("Bulut"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"),
                        "booking.additionalneeds",equalTo("wi-fi"));






    }
}
