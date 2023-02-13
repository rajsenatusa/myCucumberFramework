#Author: Can Yavas
Feature: Issuing MHO3 policy

  @mho3
  Scenario: Valid MHO3 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter MHO3 product selection information and effective date
    And I enter all required information on MHO3 quote screen
    And I enter all required information on MHO3 dwelling screen
    And I enter all required information on MHO3 review screen
    And I create MHO3 application
    Then I validate the MHO3 policy has been created successfully
