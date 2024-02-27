package com.xyz.petstore.tests;

import com.xyz.petstore.helper.Base;
import com.xyz.petstore.pojo.Category;
import com.xyz.petstore.pojo.Pet;
import com.xyz.petstore.pojo.Tag;
import io.restassured.response.Response;
import org.mozilla.javascript.serialize.ScriptableOutputStream;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class BasicRequestsDemo extends Base {

    Pet petObj = new Pet();
    Category categoryObj  = new Category(15,"aman");
    List<Tag> tagObjLst = new ArrayList<Tag>();
    
    @Test
    //Fetch the Response and print
    public void verifyFindByStatus2() {

       Response res =
       given()
                .spec(requestSpec)
                .queryParam("status", "sold")
       .when()
                .get("findByStatus")
       .then()
                .extract().response();
       res.prettyPrint();
    }
    
    @Test
    //Validate the Respone- PENDING
    public void verifyFindByStatus3() {

                given()
                        .spec(requestSpec)
                        .queryParam("status", "sold")
                .when()
                        .get("findByStatus")
                .then()
                        .body("$[0].id", equalTo(113));

    }
   

    @Test
    //Validate POST Request with body
    public void verifyAddNewPet() {
        petObj.setId(2L);
        petObj.setCategory(categoryObj);
        
        tagObjLst.add(new Tag(7, "random"));
        petObj.setTags(tagObjLst);
        
        ArrayList<String> photoLst = new ArrayList<>();
        photoLst.add("abc");
        petObj.setPhotoUrls(photoLst);
        
        petObj.setStatus("available");
       
        Response res =
                given()
                        .spec(requestSpec)
                        .header("content-type","application/json")
                        .body(petObj)
                .when()
                        .post()
                .then()
                        .extract().response();

        System.out.println(res.statusCode());
        res.prettyPrint();

    }
    

    @Test
    //Validate DELETE Request
    public void verifyDeletePetId() {

        Response res =
                given()
                        .header("api_key","abc")
                        .pathParam("id","94")
                .when()
                        .delete("{id}")
                .then()
                        .extract().response();

        System.out.println(res.statusCode());
        System.out.println(res.headers());
        res.prettyPrint();
    }
}
