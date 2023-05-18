@Epic=authenticationTest
Feature: Feature - Android Web browser login

  Background:
    When user navigates to "https://www.saucedemo.com/"

#  @Regression
  Scenario Outline: 1562447 - Android Web browser login successful
    And user enter username "<user>"
    And user enter password "<password>"
    And user click on login Button
    Then user should see page title as "Swag Labs"

    Examples:
      | user          | password     |
      | standard_user | secret_sauce |

#  @Regression
  Scenario Outline: 1562448 - Android Web browser login failed
    And user enter username "standard_user"
    And user enter password "secret_sauce2"
    And user click on login Button
    Then user should see error message displayed as "<message>"

    Examples:
      | message |
      | Epic sadface: Username and password do not match any user in this service |