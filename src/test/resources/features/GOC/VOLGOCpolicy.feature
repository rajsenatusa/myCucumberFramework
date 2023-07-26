#Author:Can Yavas
#updated on 07/14/2023 by Can Yavas
#added datatable on 07/21/2023 by C.Yavas

Feature: Issuing Golf Cart policy

  @goc @smoke
  Scenario: Valid GOC policy creation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters GOC product selection information and effective date
    And User enters all required information on GOC quote screen
    And User enters all required information on GOC golfcart screen
    And User enters driver information on driver screen
    And User enters vehicles information on vehicles screen
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that GOC policy has been created successfully

	@gocdatatable
  Scenario: GOC policy creation with multiple customers
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    Then User creates GOC policy with passing information from excel "goccustomerInfo" sheet
    ##User can change excel data table contents from /testdata folder from GOC.xlsx

@GOC_TC16801
Scenario: Valid GOC policy date transaction in future for 61 days and sent for approval
		#Given I signin Spin as Standard Agent
    #When I start transaction as a New Customer
    #When  I enter Quote Information as effective date with "61" days difference and state "Florida" and "AI" Insurance Carrier group 
    #And I select the product from Product Selection List as "GOC"
    #And I enter all required information on customer information screen
    #And I enter GOC product selection information and effective date