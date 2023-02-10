#Author: Can Yavas
Feature: Issuing HO6 policy

  @smoke2
  Scenario: Valid HO6 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter HO6 product selection information and effective date
    And I enter all required information on HO6 quote screen
    And I enter all required information on HO6 dwelling screen
    And I enter all required information on HO6 review screen
    And I create HO6 application
    Then I validate the HO6 policy has been created successfully
