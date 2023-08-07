Feature: /register POST

  Scenario: Unsuccessful register
    When I call POST register with username "new-user", email "new@example.com", password "N3wuser!"
    Then The endpoint returns status code 400
    And The endpoint returns error "Note: Only defined users succeed registration"

  Scenario: Register without password should fail
    When I call POST register with username "new-user", email "new@example.com", password "undefined"
    Then The endpoint returns status code 400
    And The endpoint returns error "Missing password"

  Scenario: Successful register
    When I call POST register with username "eve.holt@reqres.in", email "pistol", password "N3wuser!"
    Then The endpoint returns status code 200
    And The endpoint returns a register response