Feature: /users/{id} PATCH

  Scenario: Successfully patch a user - all fields
    When I call PATCH users with id "1", email "test@example.com", first_name "Joe", last_name "Bloggs", avatar "https://example.com/somepic.png"
    Then The endpoint returns status code 200
    And The endpoint returns a user updated response with id 1, email "test@example.com", first_name "Joe", last_name "Bloggs", avatar "https://example.com/somepic.png"

  Scenario: Successfully patch a user - email
    When I call PATCH users with id "1", email "test@example.com", first_name "undefined", last_name "undefined", avatar "undefined"
    Then The endpoint returns status code 200
    And The endpoint returns a user updated response with id 1, email "test@example.com", first_name "undefined", last_name "undefined", avatar "undefined"

  Scenario: Successfully patch a user - first_name
    When I call PATCH users with id "1", email "undefined", first_name "Joe", last_name "undefined", avatar "undefined"
    Then The endpoint returns status code 200
    And The endpoint returns a user updated response with id 1, email "undefined", first_name "Joe", last_name "undefined", avatar "undefined"

  Scenario: Successfully patch a user - last_name
    When I call PATCH users with id "1", email "undefined", first_name "undefined", last_name "Bloggs", avatar "undefined"
    Then The endpoint returns status code 200
    And The endpoint returns a user updated response with id 1, email "undefined", first_name "undefined", last_name "Bloggs", avatar "undefined"

  Scenario: Successfully patch a user - avatar
    When I call PATCH users with id "1", email "undefined", first_name "undefined", last_name "undefined", avatar "https://example.com/somepic.png"
    Then The endpoint returns status code 200
    And The endpoint returns a user updated response with id 1, email "undefined", first_name "undefined", last_name "undefined", avatar "https://example.com/somepic.png"

