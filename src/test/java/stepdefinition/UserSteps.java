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

    /**
     * Sends a GET request to retrieve a user by ID.
     * @param id the user ID
     */
    @When("I send a GET request to retrieve user with ID {string}")
    public void i_send_a_get_request_to_retrieve_user_with_id(String id) {
        response = given().when().get("/users/" + id);
    }

    
    /**
     * Verifies the response status code.
     * @param statusCode the expected status code
     */
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        assertEquals(response.getStatusCode(), (int) statusCode);
    }

    /**
     * Verifies the username in the response.
     * @param username the expected username
     */
    @Then("the username should be {string}")
    public void the_username_should_be(String username) {
        String actualUsername = response.jsonPath().getString("username");
        assertEquals(actualUsername, username);
    }
    
    /**
 * Sends a GET request to retrieve a non-existent user by ID.
 * @param id the user ID
 */
@When("I send a GET request to retrieve a non-existent user with ID {int}")
public void i_send_a_get_request_to_retrieve_non_existent_user_with_id(Integer id) {
    response = given().when().get("/users/" + id);
}

/**
 * Verifies the response status code for a non-existent user.
 * @param statusCode the expected status code
 */
@Then("the response status code for non-existent user should be {int}")
public void the_response_status_code_for_non_existent_user_should_be(Integer statusCode) {
    assertEquals(response.getStatusCode(), (int) statusCode);
}

 

/**
 * Sends a GET request to retrieve a user with an invalid ID.
 * @param id the invalid user ID
 */
@When("I send a GET request to retrieve user with invalid ID {string}")
public void i_send_a_get_request_to_retrieve_user_with_invalid_id(String id) {
    response = given().when().get("/users/" + id);
}

/**
 * Verifies the response status code for an invalid user ID.
 * @param statusCode the expected status code
 */
@Then("the response status code for invalid user ID should be {int}")
public void the_response_status_code_for_invalid_user_id_should_be(Integer statusCode) {
    assertEquals(response.getStatusCode(), (int) statusCode);
}

/**
 * Verifies the response time for the API.
 * @param maxResponseTime the maximum allowed response time in milliseconds
 */
@Then("the response time should be less than {int} milliseconds")
public void the_response_time_should_be_less_than(Integer maxResponseTime) {
    long responseTime = response.getTime();
    assertEquals(responseTime < maxResponseTime, true, "Response time exceeded the limit.Actual response time: " + responseTime + " ms");
}

/**
 * Verifies the response contains all required fields.
 */
@Then("the response should contain {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
public void the_response_should_contain_all_required_fields(String id, String name, String username, String email, String address, String phone, String website, String company) {
    assertEquals(response.jsonPath().get("id") != null, true);
    assertEquals(response.jsonPath().get("name") != null, true);
    assertEquals(response.jsonPath().get("username") != null, true);
    assertEquals(response.jsonPath().get("email") != null, true);
    assertEquals(response.jsonPath().get("address") != null, true);
    assertEquals(response.jsonPath().get("phone") != null, true);
    assertEquals(response.jsonPath().get("website") != null, true);
    assertEquals(response.jsonPath().get("company") != null, true);
}

/**
 * Verifies that the username is not case-sensitive.
 * @param username the expected username
 */
@Then("the username should not be case-sensitive")
public void the_username_should_not_be_case_sensitive() {
    String actualUsername = response.jsonPath().getString("username");
    assertEquals(actualUsername.equalsIgnoreCase("Bret"), true);
}


    
}
