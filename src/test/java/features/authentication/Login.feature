@Epic=authenticationTest
Feature: Feature - Login

  Scenario Outline: Scenario - 1562448 - Login successful
    When user navigates to "https://www.saucedemo.com/"
    And user enter username "<user>"
    And user enter password "<password>"
    And user tap on Login Button
    Then user should see page title as "Swag Labs"

    Examples:
      | user          | password     |
      | standard_user | secret_sauce |