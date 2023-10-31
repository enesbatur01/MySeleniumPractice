package api.testData;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;

public class TestDataHerokuapp {

    public static JSONObject jsonRequestBodyCreate (){

        JSONObject dateObj = new JSONObject();
        JSONObject body = new JSONObject();
        dateObj.put("checkin","2021-06-01");
        dateObj.put("checkout","2021-06-10");

        body.put("firstname","Ahmet");
        body.put("lastname","Bulut");
        body.put("totalprice",500);
        body.put("depositpaid",false);
        body.put("bookingdates",dateObj);
        body.put("additionalneeds","wi-fi");

        return body;
    }

    public static JSONObject jsonResponseBodyCreate(){
        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",jsonRequestBodyCreate());

        return expectedData;
    }
}
