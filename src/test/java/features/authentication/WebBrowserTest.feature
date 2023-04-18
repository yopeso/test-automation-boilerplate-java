@Epic=authenticationTest
Feature: Feature - Web browser login

  Scenario Outline: 1562447 - Successful login
    When user navigates to "https://www.saucedemo.com/"
    And user enter username "<user>"
    And user enter password "<password>"
    And user tap on login Button
    Then user should see page title as "Swag Labs"

    Examples:
      | user          | password     |
      | standard_user | secret_sauce |

  Scenario: 1562448 - Failed login
    When user navigates to "https://www.saucedemo.com/"
    And user enter username "standard_user"
    And user enter password "secret_sauce"
    And user tap on login Button
    Then user should see page title as "Swag"