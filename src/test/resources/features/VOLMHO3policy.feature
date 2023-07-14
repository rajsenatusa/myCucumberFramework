#Author: Can Yavas
#updated on 07/14/2023 by Can Yavas

Feature: Issuing MHO3 policy

  @mho3 @smoke
  Scenario: Valid MHO3 policy creation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters MHO3 product selection information and effective date
    And User enters all required information on MHO3 quote screen
    And User enters all required information on MHO3 dwelling screen
    And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that MHO3 policy has been created successfully
