package com.xyz.petstore.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.xyz.petstore.helper.Base;

import io.restassured.response.Response;

public class ParameterTypesDemo extends Base{
	
	@Test
    //Query Parameters
    public void verifyFindByStatus() {

        given()
                .spec(requestSpec)
                .queryParam("status", "sold")
        .when()
                .get("findByStatus")
        .then()
                .spec(responseSpec);

    }
	
	@Test
    // Path Parameter
    public void verifyPetId() {
        Response res =

        given()
                .pathParam("id","101011")
        .when()
                .get("{id}")
        .then()
                .extract().response();
        res.prettyPrint();

    }
	
	@Test
    //Path and Form Parameter
    public void verifyAddNewPet1() {
        Response res =
                given()
                        .header("content-type","application/x-www-form-urlencoded")
                        .formParam("name","fish")
                        .formParam("status","pending")
                        .pathParam("id","10")
                .when()
                        .post("{id}")
                .then()
                        .extract().response();

        System.out.println(res.statusCode());
        res.prettyPrint();

    }

}
