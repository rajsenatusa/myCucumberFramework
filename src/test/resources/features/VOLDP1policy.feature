#Author: Can Yavas
#updated on 07/14/2023 by Can Yavas
#added datatable on 07/20/2023 by C.Yavas
Feature: Issuing DP1 policy

  @dp1 @smoke
  Scenario: Valid DP1 policy creation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters DP1 product selection information and effective date
    And User enters all required information on DP1 quote screen
    And User enters all required information on DP1 dwelling screen
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that DP1 policy has been created successfully

  @dp1datatable
  Scenario: VOL DP1 policy creation with multiple customers
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    Then User creates DP1 policy with passing information from excel "dp1customerInfo" sheet
    ##User can change or add new customer with the help of excel data table contents from /testdata folder from VOLDP1.xlsx
		##Do not change coloum
