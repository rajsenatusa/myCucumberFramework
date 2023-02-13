#Author:Can Yavas
Feature: Issuing Golf Cart policy

  @goc
  Scenario: Valid GOC policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter GOC product selection information and effective date
    And I enter all required information on GOC quote screen
    And I enter all required information on GOC golfcart screen
    And I enter driver information on driver screen
    And I enter vehicles information on vehicles screen
    And I enter all required information on GOC review screen
    And I create GOC application
    Then I validate the GOC policy has been created successfully

