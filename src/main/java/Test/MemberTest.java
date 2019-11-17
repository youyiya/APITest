package Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Cuiping.ma on 2019/11/16 9:59 下午
 */
public class MemberTest {

    public final static String corp_id = "ww3e6a2f25acb350e7";
    public final static String agent_id = "1000002";
    public final static String agent_secret = "LSagMnHbw9F-8K6ny9aWY07IWskcejsGZvYLJGVSco4";
    public final static String contact_secret = "F5Z9UfjM-HgTt3iJl4FxCv_OYv_aLMNCuW7W_QpXJpg";
    private static final Logger logger = LoggerFactory.getLogger(MemberTest.class);
    public static String access_token = null;

    @Test
    public void getToken() {
        //直接使用extract提取需要的json值
        access_token = given()
                .params("corpid", corp_id, "corpsecret", contact_secret)
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .statusCode(200)
                .extract().path("access_token");
        logger.info("获取的token值：" + access_token);
        //通过jsonpath获取json值
        Response response = given()
                .params("corpid", corp_id, "corpsecret", contact_secret)
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken");
        JsonPath jsonPath = response.jsonPath();
        access_token = jsonPath.get("access_token");
        logger.info("jsonpath方式获取access_token:" + access_token);
    }

}
