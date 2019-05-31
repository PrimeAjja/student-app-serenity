package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Jay Vaghani on 31-May-2019
 */

public class CreateStudentDataDrivenTest extends TestBase {

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String course;

    @Title("DataDriven Test for adding multiple students to the Student App.")
    @Test
    public void createMultiplestudents(){

        ArrayList<String> courses = new ArrayList<>();
        courses.add(course);

    }
}
