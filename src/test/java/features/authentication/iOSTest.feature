@Epic=authenticationTest
Feature: Feature - iOS Login

#  @Regression
  Scenario: 1562447 - iOS app login successful
    When user tap onboarding login button
    And user select and tap Deutschland
    And user enter valid credentials
    And user tap login button
    And user tap skip and allow buttons
    Then user should see the page title as "Aktuell"

#  @Regression
  Scenario Outline: 1562448 - iOS app login failed
    When user tap onboarding login button
    And user select and tap Deutschland
    And user enter username as "limangotesting@gmail.com"
    And user enter password as "testnomarketplace2"
    And user tap login button
    Then user should see alert message pop up as "<message>"
    And user tap Ok button

    Examples:
      | message |
      | Login nicht erfolgreich. Bitte prüfe E-Mailadresse und Passwort. |