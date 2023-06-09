package org.TREE.BusinessLayer;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.TREE.Utils.CommonMethods;
import org.TREE.Utils.CommonStaticEnumStrings;
import org.TREE.Utils.PropertyReader;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class Api_Logics {

    public static Response request;
    public static JsonPath js;
    public static String bodyStringValue;
    public static ResponseBody resBody;
    public static String configFile = CommonStaticEnumStrings.configPath.getCommonStrings();

    public static void Get_Api_Reqres() {
        try {
            request = CommonMethods.common_Headers(PropertyReader.getConfigValue(configFile, "apiBaseUrl"))
                    .log().all().when().get("/api/users?page=2")
                    .then().log().all()
                    .statusCode(200)
                    .extract().response();
            js = CommonMethods.convertToJson(request.toString());
            System.out.println(js);
            String ress = request.asString();
            Assert.assertEquals(ress.toLowerCase().contains("lindsay"), true);
            CommonMethods.assert_VerificationText(js.getString("data.first_name[3]"), "Byron");

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public static void Post_Api_Reqres() {
        try {
            request = CommonMethods.common_Headers(PropertyReader.getConfigValue(configFile, "apiBaseUrl"))
                    .log().all().body(CommonMethods.post_Payload())
                    .when().post("/api/users")
                    .then().log().all()
                    .statusCode(HttpStatus.SC_CREATED)
                    .extract().response();
            resBody = request.getBody();
            bodyStringValue = resBody.asString();
            String name = js.getString("name");
            String job = js.getString("job");
            Assert.assertTrue(bodyStringValue.contains("id"));
            Assert.assertTrue(bodyStringValue.contains("name"));
            Assert.assertTrue(bodyStringValue.contains("job"));
            System.out.println(js);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
