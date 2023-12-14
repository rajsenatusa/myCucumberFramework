##created on 09/14/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC36152_HO3_ValidateAnimalLiabilitySilverReserve_CovE_END
## Precondition-Create a NB HO3 effective 4/23/22;Reserve Package - Silver Reserve ;Cov E=500K
## HIGH LEVEL STEPS OF TEST SCRIPT:
## Validate Animal Liability limit changes to 300k (highest value in the dropdown when cov E =300k)
## Validate Animal Liability Coverage is listed under Coverage List section with applicable limit selected and the applicable premium based on limit
## Validate Animal Liability Coverage is displayed on Rates Confirmation tile 
## Validate the selection is retained  after Processing EN.
## Validate on Dec page -Animal Liability selection is  reflected under optional coverages section.
    
## EXPECTED RESULTS:Validate the Animal Liability selections available based on the Coverage E Liability Limit selected
  
## User:AG1730

@regression @mtr357 @ho3regression
Feature: TC36152-HO3 Validate Animal Liability SilverReserve CovE END

  Scenario: Validate the Animal Liability selections available based on the Coverage E Liability Limit selected
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr357>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr357>
		And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr357>
		And User enters all required information on HO3 dwelling screen <mtr357>
		And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
		And User completes required information on dwelling chevron <mtr357>
    And User clicks Finalize button <mtr357>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr357>
    And User searches for the policy number <mtr357>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date and starts endorsement <mtr357>
		And User clicks Dwelling Chevron <mtr357>
    And User selects COV E personal liability as <300.000$>
    And User validates Animal Liability defaulted to <300.000$> and validates all possible dropdown options are visible
    And User validates Animal Liability Coverage is displayed on UI
    And User clicks Finalize button <mtr357>
		And User process and completes endorsement <mtr357>
    And User clicks Policy File Chevron <mtr357>
    And User clicks Endorsement Package link and validate form version <mtr357> and completes test
    
    
    
    
    