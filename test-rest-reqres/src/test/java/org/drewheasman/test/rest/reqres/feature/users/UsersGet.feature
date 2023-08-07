Feature: /users GET

  Scenario: Successfully get a users list
    When I call GET users
    Then The endpoint returns status code 200
    And The endpoint returns page 1, per_page 6, total 12, total_pages 2
    And The endpoint returns a users list
