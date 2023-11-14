##created on 11/10/2023 by Can Yavas

 # TEST CASE NUMBER & TITLE: TC36868 : E-Signature  DP1 - NB After 07/01/2022 with Joint Insured
 # PRECONDITIONS (IF ANY)
 # HIGH LEVEL STEPS OF TEST SCRIPT:  As a valid user role, create a DP1 NB (Joint) with selecting Esignature on CloseOut Screen
  
 # EXPECTED RESULTS: DP1 policy is created using eSignature feature.
  
 # User: AG1730
 
@tc36868 @regression
Feature: TC36868 : E-Signature - DP1 - NB After 07/01/2022 with Joint Insured

  Scenario: Validate that DP1 policy is created using eSignature feature
    
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer as joint
   	And User enters all required information on policy information screen as joints <tc36868>
    And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen <tc36868>
    And User enters all required information on DP1 dwelling screen <tc36868>
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User sets Number of Stories as 3 and validates 'Premium amount includes Mandatory Mediation-Arbitration discount. Signed acknowledgement must be attached to policy in SPIN within 15 days' message visible
    And User sets Esignature and validates first 2 signer fields have been enabled and not editable, 3rd one enabled and editable <tc36868>
    And User clicks issue new business button and validates 'Missing required information' text has been displayed <tc36868>
    And User inputs just Signer 1 First Name and clicks issue new business button and validates 'Missing required information' text has been displayed <tc36868>
    And User inputs Signer 1 Last Name and clicks issue new business button and validates 'Missing required information' text has been displayed <tc36868>
    And User inputs same email address which previously entered and clicks issue new business button and validates 'Email address must be different for each Signer. Please update email address' text has been displayed <tc36868>
    And User inputs 3rd email address and clicks issue new business button and validates 'Missing required information' text has been displayed <tc36868>
    And User inputs license number and clicks issue new business button and issues policy <tc36868>
    Then User clicks ESignature Tab and do validations for expected buttons, labels, texts <tc36868>
    
    