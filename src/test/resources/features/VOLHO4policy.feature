#Author: Can Yavas
#updated on 07/14/2023 by Can Yavas
#added datatable on 07/19/2023 by C.Yavas
Feature: Issuing HO4 policy

  @ho4 @smoke
  Scenario: Valid HO4 policy creation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO4 product selection information and effective date
    And User enters all required information on HO4 quote screen
    And User enters all required information on HO4 dwelling screen
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO4 policy has been created successfully

    @ho4datatable
  Scenario: VOL HO4 policy creation with multiple customers
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    Then User creates HO4 policy with passing information from excel "ho4customerInfo" sheet
    ##User can change or add new customer with the help of excel data table contents from /testdata folder from VOLHO4.xlsx
		##Do not change coloumn names or coloumn types 