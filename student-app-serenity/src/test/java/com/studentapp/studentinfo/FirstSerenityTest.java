package com.studentapp.studentinfo;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Jay Vaghani on 30-May-2019
 */

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "http://localhost:8080/student";
    }


    @Test
    public void getAllStudents(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(200).log().all();

    }

    @Test
    public void thisIsAFailing(){

    }

    @Test
    public void thisIsAPendingTest(){

    }

    @Test
    public void thisIsASkippedTest(){

    }

    @Test
    public void thisIsATestWithError(){
        System.out.println("This is an error"+(5/0));

    }

    @Test
    public void thisIsAManualTest(){

    }

    @Title("")
    @Test
    public void test01(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void fileDoesNotExist() throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }
}
