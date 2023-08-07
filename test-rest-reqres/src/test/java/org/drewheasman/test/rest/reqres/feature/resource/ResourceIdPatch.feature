Feature: /{resource}/{id} PATCH

  Scenario: Successfully update a resource - all fields
    When I call PATCH with resource "some-resource", id "1", name "some-name", year 2000, color "blue", pantone_value "blue"
    Then The endpoint returns status code 200
    And The endpoint returns a resource updated response with id "1", name "some-name", year 2000, color "blue", pantone_value "blue"

  Scenario: Successfully update a resource - name only
    When I call PATCH with resource "some-resource", id "1", name "some-name", year -82, color "undefined", pantone_value "undefined"
    Then The endpoint returns status code 200
    And The endpoint returns a resource updated response with id "1", name "some-name", year -82, color "undefined", pantone_value "undefined"

  Scenario: Successfully update a resource - year only
    When I call PATCH with resource "some-resource", id "1", name "undefined", year 2000, color "undefined", pantone_value "undefined"
    Then The endpoint returns status code 200
    And The endpoint returns a resource updated response with id "1", name "undefined", year 2000, color "undefined", pantone_value "undefined"

  Scenario: Successfully update a resource - color only
    When I call PATCH with resource "some-resource", id "1", name "undefined", year -82, color "blue", pantone_value "undefined"
    Then The endpoint returns status code 200
    And The endpoint returns a resource updated response with id "1", name "undefined", year -82, color "blue", pantone_value "undefined"

  Scenario: Successfully update a resource - pantone_value only
    When I call PATCH with resource "some-resource", id "1", name "undefined", year -82, color "undefined", pantone_value "blue"
    Then The endpoint returns status code 200
    And The endpoint returns a resource updated response with id "1", name "undefined", year -82, color "undefined", pantone_value "blue"
