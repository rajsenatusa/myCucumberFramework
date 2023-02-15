#Author: Can Yavas


Feature: Issuing TODP1 policy

  @todp1
  Scenario: Valid TODP1 policy creation
    Given I signin Spin as Admin Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter product selection information for TODP1 and effective date
    And I enter all required information on TODP1 quote screen
    And I enter all required information on TODP1 dwelling screen
    And I enter all required information on TODP1 review screen
    And I create TODP1 application
    Then I validate the TODP1 policy has been created successfully
    
    ##change user to admin for issuing Takeout policies