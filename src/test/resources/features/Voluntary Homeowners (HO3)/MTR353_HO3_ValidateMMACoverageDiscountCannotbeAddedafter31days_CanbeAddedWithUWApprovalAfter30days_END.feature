##created on 09/12/2023 by Can Yavas

 ## TEST CASE NUMBER & TITLE: TC38454_HO3_ValidateMMACoverageDiscountonNBAndEndorsement
 ## Precondition-Issue NB effective 04/22/2022,MMA =No
 ## HIGH LEVEL STEPS OF TEST SCRIPT:  

 ## EXPECTED RESULTS:Agent cannot add the Mandatory Mediation-Arbitration Coverage after 31 days(mid term endorsement) and agent can add after 30 days
  
 ## User:AG1730

@regression @mtr353 @ho3regression
Feature: TC38454 HO3 Validate MMA Coverage Discount on NB And Endorsement

  Scenario: Validate MMA Coverage Discount on NB And Endorsement
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr353>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr353>
    And User enters all required information on HO3 dwelling screen <mtr353>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr353>
    And User finalizes transaction for VOL HO3 <mtr353>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr353>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 31 days and starts endorsement <mtr353>
    And User clicks Dwelling Chevron <mtr353>
    And User validates MMA Index is editable
    And User clicks Finalize button <mtr353>
    And User clicks Modify Application and cancels transaction
    And User searches for the policy number <mtr353>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 30 days and starts endorsement <mtr353>
    And User clicks Dwelling Chevron <mtr353>
    And User sets Mediation Arbitration as Yes
    And User clicks Finalize button <mtr353>
    And User validates 'Mediation Arbitration Change requires Underwriting Approval' text is visible
    And User takes note of the application for <mtr353>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr353>
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <mtr353>
    And User process and completes endorsement and finishes test <mtr353>
    
    
    
    
    
    
    
    
    
    
    
    
    