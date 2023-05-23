@Epic=authenticationTest
Feature: Feature - Android app Login

#  @Regression
  Scenario Outline: 1562447 - Android app Login successful
    When user tap on the Login text button
    And user select and tap on Germany
    And user enter the username "<user>"
    And user enter the password "<password>"
    And user tap on login text button
    And user tap on add later button
    Then user should see the screen title as "Aktuell"

    Examples:
      | user                     | password          |
      | limangotesting@gmail.com | testnomarketplace |

#  @Regression
  Scenario Outline: 1562448 - Android app Login failed
    When user tap on the Login text button
    And user select and tap on Germany
    And user enter the username "<user>"
    And user enter the password "<password>"
    And user tap on login text button
    Then user should see invalid credentials message displayed

    Examples:
      | user                     | password           |
      | limangotesting@gmail.com | testnomarketplace2 |