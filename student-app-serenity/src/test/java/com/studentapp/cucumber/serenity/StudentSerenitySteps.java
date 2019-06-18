package com.studentapp.cucumber.serenity;

import com.studentapp.model.StudentPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Jay Vaghani on 31-May-2019
 */
public class StudentSerenitySteps {


    @Step("Creating student with firstName:{0}, lastName:{1}, email:{2},programme:{3} ,courses:{4}")
    public ValidatableResponse createStudent(String firstName,String lastName, String email, String programme,
                                             List<String> courses){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courses);


        return SerenityRest.rest().given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .body(studentPojo)
                .post()
                .then();
    }

    @Step("Getting the student information with firstName: {0}")
    public HashMap<String,Object> getStudentInfoByFirstName(String firstName){
        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        return	SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .extract()
                .path(p1+firstName+p2);
    }

    @Step("Updating student information with studentID: {0} firstName:{1}, lastName:{2}, email:{3},programme: {4} ,courses:{5}")
    public  ValidatableResponse updateStudent(int studentId, String firstName,
                                              String lastName, String email, String programme,
                                              List<String> courses) {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courses);

        return SerenityRest.rest().given()
                .contentType(ContentType.JSON).log().all()
                .when().body(studentPojo).put("/" + studentId).then();
    }

    @Step("Deleting student information with ID: {0}")
    public  void deleteStudent(int studentId) {
        SerenityRest.rest().given().when().delete("/" + studentId);
    }


    @Step("Getting information of the student with ID: {0}")
    public ValidatableResponse getStudentById(int studentId){
        return
                SerenityRest
                        .rest()
                        .given()
                        .when()
                        .get("/" + studentId).then();

    }
}
