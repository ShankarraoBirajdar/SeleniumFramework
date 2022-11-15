@tag
Feature: Title of your feature
  I want to use this template for my feature file

@ignore
  Scenario: Title of your scenario
    Given I Open Broswer
    When I Navigate to saucedemo Application
    And I Enter "standard_user" into "txtUsername" present in "common"
    And I Enter "secret_sauce" into "txtPassword" present in "common"
    And I click "btnSubmit" present in "common"
    Then I click "btnOpenMenu" present in "homepage"
    And I Log Out
    And I Close Broswer
