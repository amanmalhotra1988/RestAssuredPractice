package com.xyz.petstore.helper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class Base {
    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    @BeforeClass
    public void setupSpecification()
    {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setBasePath("pet/")
                .addHeader("content-type","application/xml")
                .build();
        responseSpec = (ResponseSpecification) new ResponseSpecBuilder()
                .expectStatusCode(200).build();


    }
}
