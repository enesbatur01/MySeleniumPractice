package api.baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseUrlHerokuapp {
    protected RequestSpecification specHerokuapp;

    @BeforeTest
    public void setUp(){
        specHerokuapp = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}
