package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jay Vaghani on 30-May-2019
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCURDTest extends TestBase {

    static int studentId;

    @Title("This test will create a new student")
    @Test
    public void test001(){

        ArrayList<String> courses = new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Manish");
        studentPojo.setLastName("Irachande");
        studentPojo.setEmail("abc@gmail.com");
        studentPojo.setProgramme("Computer Science");
        studentPojo.setCourses(courses);


        SerenityRest.rest().given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .body(studentPojo)
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
                .path(p1+"Manish"+p2);

        studentId = (int) value.get("id");

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

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Manish1");
        studentPojo.setLastName("Irachande");
        studentPojo.setEmail("abc@gmail.com");
        studentPojo.setProgramme("Financial Science");
        studentPojo.setCourses(courses);


        SerenityRest.rest().given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .body(studentPojo)
                .put("/"+studentId)
                .then().log().all().statusCode(200);

        HashMap<String, Object> value = SerenityRest.rest().given()
                .when()
                .get("/list")
                .then().log().all()
                .statusCode(200)
                .extract()
                .path(p1+"Manish1"+p2);

        System.out.println("The value is: "+value);


    }

    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004(){
        SerenityRest.rest()
                .given()
                .when()
                .delete("/"+studentId).then().statusCode(204);

        SerenityRest.rest()
                .given()
                .when()
                .get("/"+studentId)
                .then().log().all()
                .statusCode(404);
    }
}
