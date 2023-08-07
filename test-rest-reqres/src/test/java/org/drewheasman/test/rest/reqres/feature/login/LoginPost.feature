Feature: /login POST

  Scenario: Cannot login with non-existent user
    When I call POST login with username "some-user", email "me@example.com", password "N0treal"
    Then The endpoint returns status code 400
    And The endpoint returns error "user not found"

  Scenario: Cannot login with non-existent user
    When I call POST login with username "undefined", email "eve.holt@reqres.in", password "cityslicka"
    Then The endpoint returns status code 200
    And The endpoint returns a login response