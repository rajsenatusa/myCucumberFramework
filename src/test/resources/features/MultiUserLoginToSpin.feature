#Author: Can Yavas
Feature: Valid Login to Spin with different Users

  @outline
  Scenario Outline: 
    Given I navigated to the spin website
    When Login with valid "<username>" and "<password>"
    And I click on the signin button
    Then I validate that I am logged in
    And I will quit the browser

    Examples: 
      | username | password |
      | ag1730   | password |
      | mkoziel  | password |
      | jfoster  | password |
