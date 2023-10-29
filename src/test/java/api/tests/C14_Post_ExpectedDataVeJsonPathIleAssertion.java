package api.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {
    @Test
    public void test(){

        /*

        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
        gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
        "checkin" : "2021-06-01",
        "checkout" : "2021-06-10"
        },
        "additionalneeds" : "wi-fi"

       ------------------------------------------------------------------------
        Response Body
        {
        "bookingid": 24,
        "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
        }
        }

         */
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject  dateObject = new JSONObject();

        dateObject.put("checkin","2021-06-01");
        dateObject.put("checkout","2021-06-10");
        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",dateObject);
        requestBody.put("additionalneeds","wi-fi");

        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",requestBody);

        Response response = given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.getJSONObject("booking").get("firstname"),responseJsonPath.getJsonObject("booking.firstname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("lastname"),responseJsonPath.getJsonObject("booking.lastname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("totalprice"),responseJsonPath.getJsonObject("booking.totalprice"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),responseJsonPath.getJsonObject("booking.depositpaid"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),responseJsonPath.getJsonObject("booking.additionalneeds"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),responseJsonPath.getJsonObject("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),responseJsonPath.getJsonObject("booking.bookingdates.checkout"));

    }
}
