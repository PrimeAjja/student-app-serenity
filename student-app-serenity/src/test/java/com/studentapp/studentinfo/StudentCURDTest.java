package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jay Vaghani on 30-May-2019
 */
public class StudentCURDTest extends TestBase {

    @Title("This test will create a new student")
    @Test
    public void test001(){

        ArrayList<String> courses = new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");


        SerenityRest.rest().given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .body("")
                .post()
                .then().log().all().statusCode(201);
    }

    @Title("Verify if the student was added to the application")
    @Test
    public void test002(){
        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        HashMap<String, Object> value = SerenityRest.rest().given()
                .when()
                .get("/list")
                .then().log().all()
                .statusCode(200)
                .extract()
                .path(p1+""+p2);

        System.out.println("The value is: "+value);

    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test003(){
        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        ArrayList<String> courses = new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");


        SerenityRest.rest().given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .body("")
                .put("/"+"")
                .then().log().all().statusCode(200);

        HashMap<String, Object> value = SerenityRest.rest().given()
                .when()
                .get("/list")
                .then().log().all()
                .statusCode(200)
                .extract()
                .path(p1+""+p2);

        System.out.println("The value is: "+value);


    }

    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004(){
        SerenityRest.rest()
                .given()
                .when()
                .delete("/"+"");

        SerenityRest.rest()
                .given()
                .when()
                .get("/"+"")
                .then().log().all()
                .statusCode(404);
    }
}
