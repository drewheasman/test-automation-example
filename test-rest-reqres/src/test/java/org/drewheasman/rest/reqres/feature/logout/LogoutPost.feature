Feature: /logout POST

  Scenario: Successful logout
    When I call POST logout
    Then The endpoint returns status code 200
    And The endpoint returns an empty object