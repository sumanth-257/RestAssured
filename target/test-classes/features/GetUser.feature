Feature: Get User API

  Scenario: Validate user details from GET API
    Given the API endpoint is available
    When I send a GET request to retrieve user with ID 1
    Then the response status code should be 200
    And the username should be "Bret"

  Scenario: Validate response for a non-existent user
    Given the API endpoint is available
    When I send a GET request to retrieve user with ID 9999
    Then the response status code should be 404

  Scenario: Validate response for invalid user ID
    Given the API endpoint is available
    When I send a GET request to retrieve user with ID "abc"
    Then the response status code should be 404


