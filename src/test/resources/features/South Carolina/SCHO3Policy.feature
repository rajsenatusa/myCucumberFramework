#Author: Can Yavas
##added on 07/31/2023

Feature: Issuing SC HO3 policy

  @scho3 @smoke
  Scenario: Valid SC HO3 policy creation
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen
    And User enters SC HO3 product selection information and effective date
    And User enters all required information on SC HO3 quote screen
    And User enters all required information on SC HO3 dwelling screen
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that SC HO3 policy has been created successfully
    
  @scho3datatable
  Scenario: SC HO3 policy creation with multiple customers
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    Then User creates SC HO3 policy with passing information from excel "scho3customerInfo" sheet
    ##User can change excel data table contents from /testdata folder from SCHO3.xlsx
