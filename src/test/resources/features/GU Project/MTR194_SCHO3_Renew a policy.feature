# Author: Can Yavas
# created on 04/24/2024
#TEST CASE NUMBER & TITLE: MTR-194: SC HO3 Renew a policy _SHO3
#Precondition: Active SC HO3  Policy
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter able to do manual renewal for SC HO3 policy
#User: Underwriter, jbarnes

@regression @mtr194 @scregression @gu 

Feature: MTR-194: SC HO3 Renew a policy _SHO3

  Scenario: Verify Underwriter able to do manual renewal for SC HO3 policy
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen <mtr194>
    And User enters SC HO3 product selection information and current date as effective date
    And User enters all required information on SC HO3 quote screen <mtr194>
    And User enters all required information on SC HO3 dwelling screen <mtr194>
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy and makes payment with credit card
    And User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr194>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr194>
    And User clicks Start Transaction
    And User selects Renewal
    And User process manual renewal on the policy <mtr194>
    Then User validates Renewal has been processed and validates Renewal tx on history chevron
    And User clicks Policy File Chevron <mtr194>
    And User validates Renewal Declaration Form Link is visible and completes test <mtr194>
    
    
    
    
    
    
    
    