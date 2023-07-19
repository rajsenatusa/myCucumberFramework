#Author: Can Yavas
#updated on 07/14/2023 by Can Yavas
#added datatable excel on 07/19/2023 by C.Yavas
Feature: Issuing HO6 policy

  @ho6 @smoke
  Scenario: Valid HO6 policy creation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO6 product selection information and effective date
    And User enters all required information on HO6 quote screen
    And User enters all required information on HO6 dwelling screen
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully

  @ho6datatable
  Scenario: VOL HO6 policy creation with multiple customers
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    Then User creates HO6 policy with passing information from excel "ho6customerInfo" sheet
    ##User can change or add new customer with the help of excel data table contents from /testdata folder from VOLHO6.xlsx
		##Do not change coloumn names or coloumn types 