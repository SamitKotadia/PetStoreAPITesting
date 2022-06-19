package org.petApi.stepdefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.petApi.utility.ConfigFileReader;
import org.petApi.utility.RestServices;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class getPetDataStepDef {

    public Response response;
    public RestServices services = new RestServices();
    ConfigFileReader configFileReader = new ConfigFileReader("API-Env.properties");

    @Given("^I have base uri$")
    public void i_have_base_uri() throws Throwable {
        assertThat(configFileReader.getApiEnvironment(), is(endsWith("petstore.swagger.io/v2")));
    }

    @When("^I execute get request by pet Id$")
    public void i_execute_get_request_by_pet_Id() throws Throwable {
        response = services.getService();
    }

    @When("^I execute post request to add pet in store$")
    public void IExecutePostRequestToAddPetInStore() throws Throwable {
        response = services.postService();
        response.prettyPrint();
    }

    @When("^I execute delete request by pet Id$")
    public void IExecuteDeleteRequestToAddPetInStore() throws Throwable {
        response = services.deleteService();
    }

    @Then("^I should see status code as \"([^\"]*)\"$")
    public void i_should_see_status_code_as(int expectedStatusCode) throws Throwable {
        response.then().statusCode(expectedStatusCode);
    }

}
