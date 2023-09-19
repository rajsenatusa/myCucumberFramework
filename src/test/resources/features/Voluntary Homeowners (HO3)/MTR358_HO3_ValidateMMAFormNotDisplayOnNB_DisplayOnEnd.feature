 ##created on 09/19/2023 by Can Yavas

 ## TEST CASE NUMBER & TITLE: MTR358_HO3_ValidateMMAFormNotDisplayOnNB_DisplayOnEnd
 ## Precondition-Issue NB effective 04/22/2022,MMA =No
 ## HIGH LEVEL STEPS OF TEST SCRIPT:  

 ## EXPECTED RESULTS:AIIC HO3 CSAU 11 21 form displays in Forms Chevron, endorsement package after endorsement when MMA=Yes
  
 ## User:AG1730

@regression @mtr358
Feature: MTR358 HO3 Validate MMA Form Not Display On NB and Display On Endorsement

  Scenario: Validate MMA Form Not Display On NB and Display On Endorsement
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr358>
		And User enters HO3 product selection information and current date as effective date
		And User enters all required information on HO3 quote screen <mtr358>
		And User enters all required information on HO3 dwelling screen <mtr358>
		And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
		And User completes required information on dwelling chevron <mtr358>
		And User clicks Forms Chevron <mtr358>
    And User validates 'AIIC HO3 CSAU 11 21' form is not visible
    And User clicks Finalize button <mtr358>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr358>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date and starts endorsement <mtr358>
    And User clicks Dwelling Chevron <mtr358>
    And User sets MMA as Yes and clicks Save
    And User clicks Finalize button <mtr358>
    And User process and completes endorsement <mtr358>
    And User clicks Forms Chevron <mtr358>
    And User validates 'AIIC HO3 CSAU 04 23' form is visible
    And User clicks form and do validations 
    And User clicks Policy File Chevron <mtr358>
    And User clicks Endorsement Package Link and validates form version and completes test
    
    
    
    
    
    
    
    
    
    