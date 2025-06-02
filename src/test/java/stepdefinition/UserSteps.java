package stepdefinition;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class UserSteps {

    private static final String BASE_URI = "https://jsonplaceholder.typicode.com";
    private Response response;

    /**
     * Sets the base URI for the API.
     */
    @Given("the API endpoint is available")
    public void the_api_endpoint_is_available() {
        baseURI = BASE_URI;
    }

    
    @When("I send a GET request to retrieve user with ID {string}")
    public void i_send_a_get_request_to_retrieve_user_with_id(String id) {
        response = given().when().get("/users/" + id);
    }
    @When("I send a GET request to retrieve user with ID {int}")
    public void i_send_a_get_request_to_retrieve_user_with_id(Integer id) {
    	response = given().when().get("/users/" + id);
    }
    
    
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        assertEquals(response.getStatusCode(), (int) statusCode);
    }

    @And("the username should be {string}")
    public void the_username_should_be(String expectedUsername) {
        String actualUsername = response.jsonPath().getString("username");
        org.testng.Assert.assertEquals(actualUsername, expectedUsername, "Username does not match");
    }

   





    
}
