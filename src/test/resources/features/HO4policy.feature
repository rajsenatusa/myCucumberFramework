#Author: Can Yavas
Feature: Issuing HO4 policy

  @smoke1
  Scenario: Valid HO4 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter HO4 product selection information and effective date
    And I enter all required information on HO4 quote screen
    And I enter all required information on HO4 dwelling screen
    And I enter all required information on HO4 review screen
    And I create HO4 application
    Then I validate the HO4 policy has been created successfully
