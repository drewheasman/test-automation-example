Feature: /{resource}/{id} PUT

  Scenario: Successfully PUT a resource
    When I call PUT with resource "overwrite-resource", id "1", name "new", year 2000, color "blue", pantone_value "blue"
    Then The endpoint returns status code 200
    And The endpoint returns a resource updated response with id "1", name "new", year 2000, color "blue", pantone_value "blue"
