@Epic=authenticationTest
Feature: Feature - Login

  Scenario Outline: 1562447 - Successful login
    When user navigates to "https://www.saucedemo.com/"
    And user enter username "<user>"
    And user enter password "<password>"
    And user tap on Login Button
    Then user should see page title as "Swag Labs"

    Examples:
      | user          | password     |
      | standard_user | secret_sauce |

  Scenario: 1562448 - Failed login
    When user navigates to "https://www.saucedemo.com/"
    And user enter username "standard_user"
    And user enter password "secret_sauce"
    And user tap on Login Button
    Then user should see page title as "Swag"

  Scenario: Scenario - 1562448 - Login successful
    When user click on the Login text button
    And user click on the drop-down button
    And user enter the username "limangotesting@gmail.com"
    And user enter the password "testnomarketplace"
    And user click on the Login text button