#Author: Can Yavas


Feature: Issuing TOMHPD policy

  @smoke1
  Scenario: Valid TOMHPD policy creation
    Given I signin Spin as Admin Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter product selection information for TOMHPD and effective date
    And I enter all required information on TOMHPD quote screen
    And I enter all required information on TOMHPD dwelling screen
    And I enter all required information on TOMHPD review screen
    And I create TOMHPD application
    Then I validate the TOMHPD policy has been created successfully
    
