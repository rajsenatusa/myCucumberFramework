#Author: Can Yavas


Feature: Issuing TOMHO policy

  @tomho
  Scenario: Valid TOMHO policy creation
    Given I signin Spin as Admin Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter product selection information for TOMHO and effective date
    And I enter all required information on TOMHO quote screen
    And I enter all required information on TOMHO dwelling screen
    And I enter all required information on TOMHO review screen
    And I create TOMHO application
    Then I validate the TOMHO policy has been created successfully
    
