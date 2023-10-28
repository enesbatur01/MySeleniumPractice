package api_test;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C05_JsonObjesiOlusturma {
    @Test
    public void testName() {

        /*
                {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "bookingdates":{
        "checkin":"2018-01-01",
        "checkout":"2019-01-01"
        },
        "totalprice":111,
        "depositpaid":true,
        "lastname":"Brown"
        }
         */
        JSONObject dateJsınObject= new JSONObject();
        JSONObject object= new JSONObject();

        dateJsınObject.put("checkin","2018-01-01");
        dateJsınObject.put("checkout","2019-01-01");

        object.put("firstname","Jim");
        object.put("additionalneeds","Breakfast");
        object.put("bookingdates",dateJsınObject);
        object.put("totalprice",111);
        object.put("depositpaid",true);
        object.put("lastname","Brown");

        System.out.println(object);


    }
}
