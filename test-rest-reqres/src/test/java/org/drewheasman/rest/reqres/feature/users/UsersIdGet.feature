Feature: /users/{id} GET

  Scenario: Successfully get a user
    When I call GET users with id "1"
    Then The endpoint returns status code 200
    And The endpoint returns a user with id 1, email "george.bluth@reqres.in", first_name "George", last_name "Bluth", avatar "https://reqres.in/img/faces/1-image.jpg"