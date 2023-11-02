package api.tests;

import api.pojos.pojoHavaDurumu.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class C34_Post_Pojo {
    @Test
    public void test01(){
        String url="https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0";
        Coord coordPojo = new Coord(-0.1257f,51.5085f);
        List<Weather> weatherList = new ArrayList<>();
        Weather weatherPojo = new Weather(801,"Clouds","broken clouds","04d");
        weatherList.add(weatherPojo);
        Main mainPojo = new Main(285.65f,285.02f,284.01f,286.63f,991,79);
        Wind windPojo = new Wind(6.32f,224);
        Clouds cloudsPojo = new Clouds(78);
        Sys sysPojo = new Sys(2,2006068,"GB",1698821590,1698856493);

        PojoDummyExampleResponse expectedResponseBody = new PojoDummyExampleResponse(coordPojo,weatherList,"stations",mainPojo,10000,windPojo,cloudsPojo,1698854647,sysPojo,0,2643743,"London",200);

        Response response = given().when().post(url);


        JsonPath responsePojo = response.jsonPath();

        Assert.assertEquals(expectedResponseBody.getCoord().getLat(),responsePojo.get("coord.lat"));
        Assert.assertEquals(expectedResponseBody.getCoord().getLon(),responsePojo.get("coord.lon"));
        Assert.assertEquals(expectedResponseBody.getBase(),responsePojo.get("base"));


    }
}
