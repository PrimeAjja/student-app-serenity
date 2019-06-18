package com.studentapp.cucumber;

import com.studentapp.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Jay Vaghani on 08-Jun-2019
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "\\src\\test\\java\\resources\\feature")
public class CucumberRunner extends TestBase {
}
