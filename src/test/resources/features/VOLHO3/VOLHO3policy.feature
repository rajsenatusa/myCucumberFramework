#Author: Can Yavas
#updated on 07/14/2023 by Can Yavas
Feature: Issuing HO3 policy

  @ho3 @smoke
  Scenario: Valid HO3 policy creation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO3 product selection information and effective date
    And User enters all required information on HO3 quote screen
    And User enters all required information on HO3 dwelling screen
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO3 policy has been created successfully

  @ho3datatable
  Scenario: HO3 policy creation with multiple customers
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    Then User creates HO3 policy with passing information from excel "ho3customerInfo" sheet
    ##User can change excel data table contents from /testdata folder from VOLHO3.xlsx
