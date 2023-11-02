package api_cucumber.stepdefinitions;

import api_cucumber.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import static io.restassured.RestAssured.given;


public class jphStepdefinitions {
   String endpoint;
   Response response;
   JsonPath responsePath;
   JSONObject requestBody;

    @Given("Kullanici {string} base URL'ini kullanir")
    public void kullanici_base_url_ini_kullanir(String istenenBaseUrl) {
        endpoint = ConfigReader.getProperty("jPHBaseUrl");
    }
    @Then("Path parametreleri icin {string} kullanir")
    public void path_parametreleri_icin_kullanir(String pathParams) {
        endpoint = endpoint+"/"+pathParams;
    }
    @And("jPH server a GET request gonderir ve testleri yapmak icin response degerini kaydeder")
    public void jphServerAGETRequestGonderirVeTestleriYapmakIcinResponseDegeriniKaydeder() {

     response = given().when().get(endpoint);
     response.prettyPrint();


    }

    @Then("jPH respons'da status degerinin {int}")
    public void jphResponsDaStatusDegerinin(int statusCode) {
      Assert.assertEquals(statusCode,response.statusCode());
    }

    @And("jPH respons'da content type degerinin {string}")
    public void jphResponsDaContentTypeDegerinin(String contentType) {
      Assert.assertEquals(contentType,response.contentType());

    }


    @Then("jPH GET respons body'sinde {string} degerinin Integer {int}")
    public void jphGETResponsBodySindeDegerininInteger(String attribute, int expectedValue) {
     responsePath=response.jsonPath();
     Assert.assertEquals(expectedValue,responsePath.getInt(attribute));

    }

    @And("jPH GET respons body'sinde {string} degerinin String {string}")
    public void jphGETResponsBodySindeDegerininString(String attribute, String expectedValue) {
     Assert.assertEquals(expectedValue,responsePath.getString(attribute));
    }



    @Then("POST request icin {string},{string},{int} {int} bilgileri ile request body olusturur")
    public void post_request_icin_bilgileri_ile_request_body_olusturur(String title, String body, Integer userId, Integer id) {
        requestBody = new JSONObject();
        requestBody.put("title",title);
        requestBody.put("body",body);
        requestBody.put("userId",userId);
        requestBody.put("id",id);
    }
    @Then("jPH server a POST request gonderir ve testleri yapmak icin response degerini kaydeder")
    public void j_ph_server_a_post_request_gonderir_ve_testleri_yapmak_icin_response_degerini_kaydeder() {
        response = given().contentType(ContentType.JSON).when().body(requestBody.toString()).put(endpoint);
        response.prettyPrint();
        responsePath = response.jsonPath();
    }
    @Then("jPH respons daki {string} header degerinin {string}")
    public void j_ph_respons_daki_header_degerinin(String header, String value) {
        Assert.assertEquals(value,response.getHeader(header));
    }


    @Then("response attribute degerlerinin {string},{string},{int} {int}")
    public void responseAttributeDegerlerinin(String title, String body, Integer userId, Integer id) {
        Assert.assertEquals(title,responsePath.get("title"));
        Assert.assertEquals(body,responsePath.get("body"));
        Assert.assertEquals(userId,responsePath.get("userId"));
        Assert.assertEquals(id,responsePath.get("id"));

    }
}
