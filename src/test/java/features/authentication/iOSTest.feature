@Epic=authenticationTest
Feature: Feature - iOS Login

#  @Regression
  Scenario: 1562447 - Login successful
    When user click onboarding login button
    And user select and click Deutschland
    And user enter valid credentials
    And user click login button
    And user click skip and allow buttons
    Then user should see the page title as "Aktuell"

#  @Regression
  Scenario: 1562448 - Login failed
    When user click onboarding login button
    And user select and click Deutschland
    And user enter valid credentials
    And user click login button
    And user click skip and allow buttons
    Then user should see the page title as "Aktuell2"