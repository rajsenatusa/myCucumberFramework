## created on 10/26/2023 by Can Yavas
 
 # TEST CASE NUMBER & TITLE: TC 23996--HO3 Adjuster Report A Loss (LN) UI Characteristic Validations
 # PRECONDITIONS (IF ANY
 # HIGH LEVEL STEPS OF TEST SCRIPT:  As an Adjuster, Report a Loss and complete the Loss Notice Information tiles, Loss Cause = Windstorm
 # EXPECTED RESULTS: Adjuster can Complete the  Loss Notice to Start Claim 
  
 # User: Tbrean

@regression @tc23996
Feature: TC 23996--HO3 Adjuster Report A Loss (LN) UI Characteristic Validations

  Scenario: Validate Adjuster can Complete the  Loss Notice to Start Claim 
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc23996>
    And User enters HO3 product selection information and current date as effective date <tc23996>
		And User enters all required information on HO3 quote screen <tc23996>
		And User enters all required information on HO3 dwelling screen and add deductible windhail <tc23996>
		And User enters all required information on HO3 review screen
		And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron and updates dwelling type <tc23996>
    And User clicks Finalize button <tc23996>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <tc23996>
		And User signs out
		And User login to Spin as Adjuster
		And User changes system date to current date plus 10 days <tc23996>
		And User searches for the policy number <tc23996>
		And User clicks Report Loss
		And User validates 'Loss Type' 'Loss Date' texts are visible and gets loss type of populated value
		And User sets loss date as current date plus 10 days <tc23996>
		And User validates Loss Notice Info Tile UI Labels
		And User validates all expected Loss Cause dropdown options 
		And User selects Catastrophic Ground Cover Collapse and validates following fields
		And User selects Fire as loss cause and validates following fields
		And User selects Water Damage as loss cause and validates following fields
		And User selects Windstorm as loss cause and validates following fields
		And User selects Sub Loss Cause and selects if roof damaged approx amount selection and do validations
		And User selects Roof damaged amount as unknown and do validations
		And User selects Examiner and do validations
		And User selects Vehicle Location as Unscheduled Location and do validations
		And User clicks save and takes note of the loss number <tc23996>
    Then User clicks Complete and takes note of the claim number and validate expected messages <tc23996>
    
		
		
		
		
		
		
		
		
		
		
		
		
		