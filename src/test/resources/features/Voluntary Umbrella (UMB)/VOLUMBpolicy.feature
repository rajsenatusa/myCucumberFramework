#Author: Can Yavas
#updated on 07/19/2023 by C.Yavas
#datatable added on 07/24/2023 by C.Yavas

Feature: Issuing UMB policy

  @smoke @umb @healthcheck
  Scenario: Valid UMB policy creation
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters UMB product selection information and effective date
    And User enters all required information on UMB quote screen
    And User enters all required information on UMB personal liability screen
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that UMB policy has been created successfully
    
  @umbSO
  Scenario Outline: Valid UMB policy creation with Scenario Outline
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for UMB and "<EffectiveDate>"
    And User enters Producer Code
    And User answers previous policy written with AIIG questions
    And User enters Primary Phone
    And User clicks No Email
    And User clicks Next on Policy Chevron 
    And User selects Umbrella Liability Coverage "<LiabilityCoverage>"
    And User selects Uninsured Limit "<UninsuredLimit>"
    And User enters Number of Auto "<NumberOfAuto>"
    And User clicks Save
    And User clicks Review Chevron
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that UMB policy has been created successfully

    Examples: Test Data
      | EffectiveDate | LiabilityCoverage | UninsuredLimit | NumberOfAuto | 
      | 1/1/2023    |     1,000,000     |       0        |      2       |           
    
    @umbdatatable
   Scenario: VOL UMB policy creation with multiple customers
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    Then User creates UMB policy with passing information from excel "umbcustomerInfo" sheet
    ##User can change or add new customer with the help of excel data table contents from /testdata folder from VOLUMB.xlsx
		##Do not change coloumn