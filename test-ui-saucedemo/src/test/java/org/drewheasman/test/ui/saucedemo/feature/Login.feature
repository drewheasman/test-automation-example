Feature: Login

  Background: Navigate to SauceDemo
    Given I start a browser session for SauceDemo

  Scenario: Login page loads
    Then The Login page is displayed

  Scenario: Submit no username or password
    When I Login with username "", password ""
    Then A Login error is displayed with text "Epic sadface: Username is required"
    When I click the Login error button
    Then The Login page is displayed

  Scenario: Submit valid credentials
    When I Login with username "standard_user", password "secret_sauce"
    Then The current url is "https://www.saucedemo.com/inventory.html"
