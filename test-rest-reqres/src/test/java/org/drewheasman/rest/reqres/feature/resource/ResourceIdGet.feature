Feature: /{resource}/{id} GET

  Scenario: Successfully get a resource
    When I call GET with resource "someResource", id "1"
    Then The endpoint returns status code 200
    And The endpoint returns resource data with id "1", name "cerulean", year 2000, color "#98B2D1", pantone_value "15-4020"
