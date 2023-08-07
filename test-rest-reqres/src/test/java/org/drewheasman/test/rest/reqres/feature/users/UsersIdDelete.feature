Feature: /users/{id} DELETE

  Scenario: Successful user delete
    When I call DELETE users with id "1"
    Then The endpoint returns status code 204