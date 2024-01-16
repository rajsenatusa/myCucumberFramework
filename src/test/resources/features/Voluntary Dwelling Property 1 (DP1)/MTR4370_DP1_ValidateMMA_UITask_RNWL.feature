#Author: Can Yavas
##created on 10/19/2023

# TEST CASE NUMBER & TITLE: TC38506: US8756 - U/I Task - Mandatory Mediation-Arbitration Acknowledgment - DP1- RNWL on 08/22/2022
# Precondition-Issue NB effective 07/01/2022,MMA =No
# HIGH LEVEL STEPS OF TEST SCRIPT:  
# 1. Validate task added when coverage added at NB & RN transaction
# 2. Validate task wording
# 3. Task will trigger 30 days after the NB or RN effective date
# 4. Task will be sent to the underwriting clerk group
# 5. If a user uploads document as mandatory mediation-arbitration acknowledgment close task
# 6. Validate the new task routes to the u/w clerk group and the task can be worked, suspended, transferred 

# EXPECTED RESULTS:Task will not be generated on RNWL on 08/22/2022  will be generated on END and referring to UW Clerk group
  
# User:AG1730


@regression @tc38506 @MTR4370 @dp1regression
Feature: MTR4370 US8756 - U/I Task - Mandatory Mediation-Arbitration Acknowledgment - DP1- RNWL on 08/22/2022

  Scenario: Validating that Task will not be generated on RNWL on 08/22/2022 will be generated on END and referring to UW Clerk group
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc38506>
    And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen <tc38506>
		And User enters all required information on DP1 dwelling screen <tc38506>
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User clicks Policy Chevron
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen, select number of stories and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy for <tc38506>
    And User clicks Make Payment and selects credit card and enters due amount <tc38506>
    And User makes payment with Credit Card <tc38506>
    And User does auto renewal through batch jobs <tc38506> 
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to renewal effective date as current date plus 1 year
    And User searches for renewed Policy Number for <tc38506>
    And User clicks Start Transaction
    And User selects Endorsement
    And User selects endorsement date as renewal effective date <tc38506>
    And User clicks Dwelling Chevron <tc38506>
    And User validates MMA selection defaulted as No
    And User sets MMA selection as Yes
    And User clicks finalize transaction
    And User validates 'Mandatory Mediation-Arbitration Changed From No to Yes' text is visible
    And User endorses policy
    And User clicks Task Tab
    And User validates 'Mandatory Mediation-Arbitration discount applied on Policy' displayed with policy number and do other necessary validation referred in test steps
    And User clicks Attachment Tab
    And User adds Inspection Attachment
    And User clicks Task Tab
    Then User selects show all and validates 'Mandatory Mediation-Arbitration discount applied on Policy' text is visible and do other validations
    
    
    
    
    
    
    
    
    
    
    
    