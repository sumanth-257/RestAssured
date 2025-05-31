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
    Then the response status code should be 400

  Scenario: Validate response time for the API
    Given the API endpoint is available
    When I send a GET request to retrieve user with ID 1
    Then the response time should be less than 2000 milliseconds

  Scenario: Validate response contains all required fields
    Given the API endpoint is available
    When I send a GET request to retrieve user with ID 1
    Then the response should contain "id", "name", "username", "email", "address", "phone", "website", and "company"

  Scenario: Validate case sensitivity of the API
    Given the API endpoint is available
    When I send a GET request to retrieve user with ID 1
    Then the username should not be case-sensitive "Bret"
    

    
    
