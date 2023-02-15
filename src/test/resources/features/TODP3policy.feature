#Author: Can Yavas


Feature: Issuing TODP3 policy

  @todp3
  Scenario: Valid TODP3 policy creation
    Given I signin Spin as Admin Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter product selection information for TODP3 and effective date
    And I enter all required information on TODP3 quote screen
    And I enter all required information on TODP3 dwelling screen
    And I enter all required information on TODP3 review screen
    And I create TODP3 application
    Then I validate the TODP3 policy has been created successfully
    
