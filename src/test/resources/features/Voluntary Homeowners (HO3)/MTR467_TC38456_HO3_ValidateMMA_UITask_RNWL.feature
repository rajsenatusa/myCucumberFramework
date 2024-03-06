## created on 10/25/2023 by Can Yavas
 
 # TEST CASE NUMBER & TITLE: TC 38456--U/I Task - Mandatory Mediation-Arbitration Acknowledgment - HO3 - RNWL on 06/21/2022
 # PRECONDITIONS (IF ANY) : Issue HO3 NB policy Effective 6/21/2021
 # HIGH LEVEL STEPS OF TEST SCRIPT:  
 # 1. Validate task added when coverage added at NB & RN transaction
 # 2. Validate task wording
 # 3. Task will trigger 30 days after the NB or RN effective date
 # 4. Task will be sent to the underwriting clerk group
 # 5. If a user uploads document as mandatory mediation-arbitration acknowledgment close task
 # 6. Validate the new task routes to the u/w clerk group and the task can be worked, suspended, transferred

 # EXPECTED RESULTS: Task will not be generated on RNWL on 06/22/2022  will be generated on END and referring to UW Clerk group
  
 # User: Gallopadmin

@regression @mtr467 @ho3regression 
Feature: TC 38456--UI Task - Mandatory Mediation-Arbitration Acknowledgment - HO3 - RNWL

  Scenario: Task will not be generated on RNWL on 06/22/2022  will be generated on END and referring to UW Clerk group
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr467>
    And User enters HO3 product selection information and current date as effective date <mtr467>
    And User enters all required information on HO3 quote screen <mtr467>
    And User enters all required information on HO3 dwelling screen <mtr467>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron selects Dwelling Type <mtr467>
    And User clicks Finalize button <mtr467>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr467>
    And User clicks Make Payment and selects credit card and enters due amount <mtr467>
    And User makes payment with Credit Card <mtr467>
    And User does auto renewal through batch jobs <mtr467> 
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to renewal effective date as current date plus 1 year <mtr467>
    And User searches for renewed Policy Number for <mtr467>
    And User clicks Start Transaction
    And User selects Endorsement
    And User selects endorsement date as renewal effective date <mtr467>
    And User clicks Dwelling Chevron <mtr467>
    And User sets MMA selection as Yes <mtr467>
    And User clicks finalize transaction
    And User validates 'Mandatory Mediation-Arbitration Changed From No to Yes' label is visible <mtr467>
    And User endorses policy
    And User clicks Task Tab
    And User validates 'Mandatory Mediation-Arbitration discount applied on Policy' displayed with policy number and do other necessary validation referred in test steps <mtr467>
    And User clicks Attachment Tab
    And User adds Inspection Attachment
    And User clicks Task Tab
    Then User selects show all and validates 'Mandatory Mediation-Arbitration discount applied on Policy' text is visible and do other validations <mtr467>
    
    
    
    
    
    
    