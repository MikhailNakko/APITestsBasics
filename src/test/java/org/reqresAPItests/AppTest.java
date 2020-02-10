package org.reqresAPItests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest
{
    /**
     * Rigorous Test :-)
     */
    public void specs(){

    }
    @Test
    public void apiFirstTest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Johnsons");
        requestParams.put("job", "janitor");
        RestAssured
                .given(requestSpecificationForPOSTWithResponseLogging(requestParams))
                .post(postCreateUserURI)
                .then().statusCode(201).body("id", is(notNullValue()));
    }

}
