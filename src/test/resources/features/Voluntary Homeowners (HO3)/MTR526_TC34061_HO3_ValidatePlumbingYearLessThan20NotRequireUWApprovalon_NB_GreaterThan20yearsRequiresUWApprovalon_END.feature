##created on 09/06/2023 by Can Yavas

##TEST CASE NUMBER & TITLE: TC 34061--US-1629: 'Risk is ineligible due to Age of Plumbing' message will 
##not displays for Plumbing age < 20 years on NB and When updating to > 20 years on END requires UW approval
  
## PRECONDITIONS (IF ANY): 
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  Validating that plumbing age < 20 years will not  generate 
## 'Risk is ineligible due to Age of Plumbing' message  
   
## EXPECTED RESULTS: When plumbing age < 20 years then 'Risk is ineligible due to Age of Plumbing' message will not 
## displays on NB
## Validate that the message will appear on END when updating plumbing year to > 20 years and requires UW approval 
  
## User: AG1730

@regression @mtr526
Feature: TC 34061--US-1629: 'Risk is ineligible due to Age of Plumbing' message will not displays for Plumbing age over 20 years on NB and When updating to over 20 years on END requires UW approval

  Scenario: Validate that the message will appear on END when updating plumbing year to over 20 years and requires UW approval
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr526>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr526>
    And User enters all required information on HO3 dwelling screen <mtr526>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron and validates 'Risk is ineligible due to age of Plumbing' text not visible
    And User finalizes transaction for VOL HO3 and validates 'Risk is ineligible due to age of Plumbing' text not visible
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr526>
    And User searches for the policy number <mtr526>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 15 days <mtr401>
    And User clicks Dwelling Chevron <mtr526>
    And User updates plumbing year as bigger than 20 years
    And User clicks Finalize button and validates 'Risk is ineligible due to age of Plumbing' message is visible
    And User takes note of the application number <mtr526>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr526>
    And User validates 'Risk is ineligible due to age of Plumbing' text is visible
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <mtr526>
    And User process and completes endorsement and finishes test <mtr526>
    
    
    
    
    