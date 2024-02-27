package com.xyz.petstore.tests;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import com.xyz.petstore.helper.Base;

import io.restassured.response.Response;

public class UploadDemo extends Base{
	
    File fileToUpload;


	@Test
    //Validate POST Request with Path and Form parameters and Upload Image
    public void verifyAddNewPetImage() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/images/tcuimages.jpg";
        System.out.println(filePath);
        fileToUpload = new File(filePath);
        Response res =
                given()
                        .header("content-type","multipart/form-data")
                        .formParam("additionalMetadata","fish")
                        .multiPart(fileToUpload )
                        .pathParam("id","10")
                .when()
                        .post("{id}/uploadImage")
                .then()
                        .extract().response();

        System.out.println(res.statusCode());
        System.out.println(res.headers());
        res.prettyPrint();

    }
}
