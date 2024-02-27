package com.xyz.petstore.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.xyz.petstore.helper.Base;
import com.xyz.petstore.pojo.Pet;

public class SerializeDeserializationDemo extends Base {
	@Test
    //Verify the Deserialization
    public void verifyFindByStatusUsingDeserialization() {

        Pet[] petObj = given()
                .spec(requestSpec)
                .queryParam("status", "sold")
        .when()
                .get("findByStatus").as(Pet[].class);
        System.out.println(petObj[1].getId());
        System.out.println(petObj[1].getName());


    }

}
