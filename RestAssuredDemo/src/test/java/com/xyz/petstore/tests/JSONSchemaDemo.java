package com.xyz.petstore.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import com.xyz.petstore.helper.Base;

public class JSONSchemaDemo extends Base  {
	 @Test
	    //Validate the JSON Schema
	    public void verifyjsonSchema() {

	        given()
	                .spec(requestSpec)
	                .queryParam("status", "sold")
	        .when()
	                .get("findByStatus")
	        .then()
	        	.body(matchesJsonSchemaInClasspath("schema/pet/find-by-status.json"));

	    }

}
