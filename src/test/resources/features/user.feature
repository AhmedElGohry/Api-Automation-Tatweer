Feature: User API Tests

  Scenario: Create user and verify status
    Given the base API is set
    When I send a POST request to create a user
    Then the response status code should be 201

  Scenario: Get users with delay
    Given the base API is set
    When I send a GET request with delay 3
    Then the first user data should not be null
