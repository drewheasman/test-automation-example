Feature: /{resource}/{id} DELETE

  Scenario: Successful resource delete
    When I call DELETE with resource "some-resource", id "1"
    Then The endpoint returns status code 204