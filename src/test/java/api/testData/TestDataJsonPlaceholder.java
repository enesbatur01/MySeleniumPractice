package api.testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceholder {

    public static int succesStatusCode =200;
    public static String contentType ="application/json; charset=utf-8";
    public static String connectionHeader ="keep-alive";


    public static JSONObject responseBodyCreate22(){

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expectedData;
    }


    public static JSONObject jsonBodyCreate (int userId,int id,String title,String body){
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",userId);
        expectedData.put("id",id);
        expectedData.put("title",title);
        expectedData.put("body",body);

        return expectedData;
    }

    public static Map<String,Object> mapBodyCreate(String title,String body,double userId, double id){

        Map<String,Object> requestBody = new HashMap<>();

        requestBody.put("title",title);
        requestBody.put("body",body);
        requestBody.put("userId",userId);
        requestBody.put("id",id);

        return requestBody;
    }

}
