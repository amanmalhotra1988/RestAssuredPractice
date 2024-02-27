package com.xyz.petstore.tests;

import org.testng.annotations.Test;

import com.xyz.petstore.helper.Base;

import io.restassured.response.Response;

import java.io.File;
import static io.restassured.RestAssured.given;


public class PayloadFromFileDemo {
	
	
	@Test
	public void temp() {
		Response res = 
			given()
				.baseUri("https://petstore.swagger.io/v2/pet")
	        	.header("content-type","application/json")
	        	.body("{\n"
	        			+ "  \"id\": 0,\n"
	        			+ "  \"category\": {\n"
	        			+ "    \"id\": 0,\n"
	        			+ "    \"name\": \"string\"\n"
	        			+ "  },\n"
	        			+ "  \"name\": \"doggie\",\n"
	        			+ "  \"photoUrls\": [\n"
	        			+ "    \"string\"\n"
	        			+ "  ],\n"
	        			+ "  \"tags\": [\n"
	        			+ "    {\n"
	        			+ "      \"id\": 0,\n"
	        			+ "      \"name\": \"string\"\n"
	        			+ "    }\n"
	        			+ "  ],\n"
	        			+ "  \"status\": \"available\"\n"
	        			+ "}")
	        	.when()
	        		.post()
	        	.then()	
	        		.extract().response();
	        	
	   res.prettyPrint();     	
	}
	
	@Test
	// Read Payload from JSON File
	public void readPayloadJSON() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/payload/json/pet.json";
		File file = new File(filePath);
		
		Response res = 
		given()
			.baseUri("https://petstore.swagger.io/v2/pet")
        	.header("content-type","application/json")
        	.body(file)
        .when()
        	.post()
        .then()
        	.extract().response();
		
		res.prettyPrint();	
	}

}
