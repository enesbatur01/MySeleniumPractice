package api.tests;

import api.baseUrl.BaseUrlHerokuapp;
import api.pojos.PojoHerokuappBookingdates;
import api.pojos.PojoHerokuappRequestBody;
import api.pojos.PojoHerokuappResponseBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C32_Post_Pojo extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        specHerokuapp.pathParam("pp1","booking");
        PojoHerokuappBookingdates pojoBookingDate = new PojoHerokuappBookingdates("2021-06-01","2021-06-10");
        PojoHerokuappRequestBody requestBody = new PojoHerokuappRequestBody("Ahmet","Bulut",500,false,pojoBookingDate,"wi-fi");
        PojoHerokuappRequestBody expectedBody = new PojoHerokuappRequestBody("Ahmet","Bulut",500,false,pojoBookingDate,"wi-fi");
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(requestBody).post("{pp1}");
        PojoHerokuappResponseBody responsePojo = response.as(PojoHerokuappResponseBody.class);

        Assert.assertEquals(expectedBody.getFirstname(),responsePojo.getBooking().getFirstname());
        Assert.assertEquals(expectedBody.getLastname(),responsePojo.getBooking().getLastname());
        Assert.assertEquals(expectedBody.getTotalprice(),responsePojo.getBooking().getTotalprice());
        Assert.assertEquals(expectedBody.getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());
        Assert.assertEquals(expectedBody.isDepositpaid(),responsePojo.getBooking().isDepositpaid());
        Assert.assertEquals(expectedBody.getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expectedBody.getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());
    }
}
