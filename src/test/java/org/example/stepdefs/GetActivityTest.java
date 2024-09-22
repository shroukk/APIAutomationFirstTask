package org.example.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetActivityTest {

    Response response;

    @Given("user makes a GET request to {string}")
    public void userMakesAGETRequestToAPI(String endpoint){
        RestAssured.baseURI = endpoint;
        response = given()
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

    @Then("user should receive a {int} status code")
    public void userShouldReceiveAStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }

    @And("the response should match the expected schema")
    public void theResponseShouldMatchTheExpectedSchema() {
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("../../main/resources/response_schema.json"));
    }
}
