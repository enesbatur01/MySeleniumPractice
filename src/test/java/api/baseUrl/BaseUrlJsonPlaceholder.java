package api.baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;

public class BaseUrlJsonPlaceholder {

    protected RequestSpecification specJsonPlaceholder;

    @BeforeTest
    public void setUp(){
        specJsonPlaceholder = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }


}
