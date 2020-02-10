package org.reqresAPItests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class BaseTest {
    private String baseURI = "https://reqres.in/";
    protected String postCreateUserURI = "/api/users";
    public RequestSpecification requestSpecsWithResponseLoggingForGET(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFilter(new ResponseLoggingFilter()).build()
                .baseUri(baseURI);
        return requestSpecification;
    }

    public RequestSpecification requestSpecsWithRequestLoggingForGET(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter()).build()
                .baseUri(baseURI);
        return requestSpecification;
    }

    public RequestSpecification requestSpecificationForPOSTWithResponseLogging(JSONObject jsonObject){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter()).build()
                .baseUri(baseURI)
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString());
        return requestSpecification;
    }

}
