package api.tests;


import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C10_JsonPathKullanimi {
    @Test
    public void testName() {
        JSONObject userInformationJsonObj=new JSONObject();
        JSONObject addressJsonObj= new JSONObject();
        JSONArray phoneInformationArr= new JSONArray();
        JSONObject cellPhoneJsonObj=new JSONObject();
        JSONObject homePhoneJsonObj=new JSONObject();

        addressJsonObj.put("streetAddress","naist street");
        addressJsonObj.put("city","Nara");
        addressJsonObj.put("postalCode","630-0192");

        cellPhoneJsonObj.put("type","iPhone");
        cellPhoneJsonObj.put("number","0123-4567-8888");

        homePhoneJsonObj.put("type","home");
        homePhoneJsonObj.put("number","0123-4567-8910");

        phoneInformationArr.put(cellPhoneJsonObj);
        phoneInformationArr.put(homePhoneJsonObj);

        userInformationJsonObj.put("firstname","John");
        userInformationJsonObj.put("lastname","doe");
        userInformationJsonObj.put("age",26);
        userInformationJsonObj.put("Address",addressJsonObj);
        userInformationJsonObj.put("phoneNumbers",phoneInformationArr);

        System.out.println(userInformationJsonObj.getJSONObject("Address").get("streetAddress"));
        System.out.println(userInformationJsonObj.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));


    }
}
