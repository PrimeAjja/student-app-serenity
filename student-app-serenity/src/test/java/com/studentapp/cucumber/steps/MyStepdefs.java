package com.studentapp.cucumber.steps;

import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;

/**
 * Created by Jay Vaghani on 08-Jun-2019
 */
public class MyStepdefs {
    @When("^User sends a GET request to the list endpoint,they must get back a valid status code 200$")
    public void userSendsAGETRequestToTheListEndpointTheyMustGetBackAValidStatusCode() {
        SerenityRest.rest().given()
                .when()
                .get("/list")
                .then().log().all().statusCode(200);
    }
}
