package api.testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataDummy {
    public static int succesStatusCode =200;
    public static String contentType ="application/json";
    public static String connectionHeader ="keep-alive";

    public static JSONObject jsonResponseBodyCreate (int id,String employee_name ,int employee_salary,int employee_age){
        JSONObject body = new JSONObject();
        JSONObject expectedData = new JSONObject();

        body.put("id",id);
        body.put("employee_name",employee_name);
        body.put("employee_salary",employee_salary);
        body.put("employee_age",employee_age);
        body.put("profile_image","");
        expectedData.put("status","success");
        expectedData.put("data",body);
        expectedData.put("message","Successfully! Record has been fetched.");
        return expectedData;

    }

    public static Map<String,Object> mapBodyCreate(){

        Map<String,Object> body = new HashMap<>();
        Map<String,Object> data = new HashMap<>();

        body.put("id",3.0);
        body.put("employee_name","Ashton Cox");
        body.put("employee_salary",86000.0);
        body.put("employee_age",66.0);
        body.put("profile_image","");
        data.put("status","success");
        data.put("data",body);
        data.put("message","Successfully! Record has been fetched.");

        return data;


    }

}
