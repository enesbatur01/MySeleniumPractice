package api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgileriniManuelTesti {

    @Test
    public void testName() {
        String url ="https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getHeader("Server"));
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());


    }

}
