package api_test;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C04_JSONObjesiOluşturma {
    @Test
    public void testName() {

        JSONObject object = new JSONObject();
        /*
        {
         "title":"Ahmet",
          "body":"Merhaba",
          "userId":1
         }
         */

        object.put("title", "Ahmet");
        object.put("body","Merhaba");
        object.put("userId",1);

        System.out.println(object);


    }
}
