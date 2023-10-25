## created on 10/25/2023 by Can Yavas
 
 # TEST CASE NUMBER & TITLE: TC 15207--Vol HO3 - Creating HO3 Application JNT w/eSignature
 # PRECONDITIONS (IF ANY)
 # HIGH LEVEL STEPS OF TEST SCRIPT:  As a valid user role, create a HO3 NB (Joint) with selecting Esignature on CloseOut Screen
  
 # EXPECTED RESULTS: HO3 policy is created using eSignature feature.
  
 # User: AG1730

@regression @tc15207
Feature: TC 15207--Vol HO3 - Creating HO3 Application JNT w/eSignature

  Scenario: Validate HO3 policy is created using eSignature feature
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer as joint
    And User enters all required information on policy information screen as joints <tc15207>
    And User enters HO3 product selection information and current date as effective date <tc15207>
    And User enters all required information on HO3 quote screen <tc15207>
    And User enters all required information on HO3 dwelling screen <tc15207>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron selects Dwelling Type <tc15207>
    And User clicks Finalize button <tc15207>
    And User sets Esignature and validates 3 signer fields have been enabled
    And User clicks issue new business button and validates 'Missing required information' text has been displayed
    And User inputs just Signer 1 First Name and clicks issue new business button and validates 'Missing required information' text has been displayed
    And User inputs Signer 1 Last Name and clicks issue new business button and validates 'Missing required information' text has been displayed
    And User inputs same email address which previously entered and clicks issue new business button and validates 'Email address must be different for each Signer. Please update email address' text has been displayed
    And User inputs 3rd email address and clicks issue new business button and validates 'Missing required information' text has been displayed
    And User inputs license number and clicks issue new business button and issues policy
    And User clicks ESignature Tab and do validations for expected buttons, labels, texts
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    