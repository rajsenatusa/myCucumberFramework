##created on 09/05/2023 by Can Yavas

  
  ## TEST CASE NUMBER & TITLE: TC38498 : US8582 - FORM: Mandatory Mediation-Arbitration Acknowledgment 
  ## AIIC HO3 MMAA 04 23 - NB After 04/22/2022 Form will display on NB Application and not displays on End package
   
  ## HIGH LEVEL STEPS OF TEST SCRIPT:  
  
  ## EXPECTED RESULTS: 
  ## Validate policy number displays correctly on page 2 
  ## Validate property address displays correctly on page 2
  ## Validate Acknowledgment form AIIC HO3 displays on the policy tab at NB as part of the Application package
  ## Validate Acknowledgment form AIIC HO3 attaches after the application in the package
   
  ## User:AG1730

  @regression @mtr355 @ho3regression
  Feature: TC38498 : US8582 - FORM: Mandatory Mediation-Arbitration Acknowledgment
  
  Scenario: MTR 355 Validate HO3 MMA AcknowledgmentFrom on NB and END
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr355>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr355>
    And User enters all required information on HO3 dwelling screen with MMA selected as Yes
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User validates MMA dropdown defaulted to yes and sets dwelling type
    And User finalizes transaction for VOL HO3
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr355>
    And User navigates to policyfile screen
    And User clicks on on the application and validate the MMA acknowledge form 'AIIC HO3 MMAA 03 22' attached in the application form
    And User searches for the policy number <mtr355>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date and starts endorsement <mtr355>
    And User clicks dwelling chevron <mtr355>
    And User validates MMA defaulted to Yes <mtr355>
    And User clicks Finalize button and Endorses Policy <mtr355> and completes test
  
    
