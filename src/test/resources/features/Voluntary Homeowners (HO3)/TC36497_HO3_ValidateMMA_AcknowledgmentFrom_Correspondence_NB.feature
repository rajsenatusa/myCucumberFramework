 ##created on 09/20/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC36497 : US8583 - U/I CORRESPONDENCE Mandatory Mediation-Arbitration Acknowledgment 
## AIIC HO3 MMAA 03 22 - HO3 - NB Joint After 04/22/2022 
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  

## EXPECTED RESULTS: 
## Validate policy number displays correctly on page 2 
## Validate property address displays correctly on page 2
## Validate Acknowledgment form AIIC HO3 displays on the policy tab at NB as part of the Application package
## Validate Acknowledgment form AIIC HO3 attaches after the application in the package
  
## User:AG1730

@regression @tc36497
Feature: TC36497 : US8583 - U/I CORRESPONDENCE Mandatory Mediation-Arbitration Acknowledgment 

  Scenario: Validate AIIC HO3 MMAA 03 22 form displays in the desired packages
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc36497>
		And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <tc36497>
    And User enters all required information on HO3 dwelling screen <tc36497>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron and validates MMA dropdown defaulted to Yes <tc36497>
    And User clicks Finalize button <tc36497>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <tc36497>
    And User clicks correspondance tab
		And User selects 'Mandatory Mediation-Arbitration Acknowledgment' from dropdown <tc36497>
		And User validates 'Producer' and 'Local Printer' texts are visible on ui
		And User clicks preview correspondance button
		And User validates form version on ui <tc36497>
    And User clicks new recipient and completes required information
    And User clicks Process Correspondance and validates quote and agent information in forms <tc36497>
    And User clicks Policy File Chevron <tc36497>
    Then User click MMA Acknowledgement and validates form version <tc36497>
    
    
    
    
    
    
    
    
    
    
    
    
    