#Author: Can Yavas
#added on 04/29/2024 by C.Yavas

Feature: Issuing HO5 policy

  @ho5 @smoke
  Scenario: Valid HO5 policy creation
    Given User login to Spin as Georgia Agent
    When User starts transaction as a new customer
    And User enters all required information on HO5 policy information screen
    And User enters HO5 product selection information and effective date as current date
    And User enters all required information on HO5 quote screen
    And User enters all required information on HO5 dwelling screen
    And User enters all required information on HO5 review screen
    And User creates HO5 application
    And User answers all underwriting questions for HO5
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO5 policy has been created successfully

  @ho5datatable
  Scenario: HO5 policy creation with multiple customers
    Given User login to Spin as Georgia Agent
    When User starts transaction as a new customer
    Then User creates HO5 policy with passing information from excel "ho5customerInfo" sheet
    ##User can change excel data table contents from /testdata folder from VOLHO5.xlsx
