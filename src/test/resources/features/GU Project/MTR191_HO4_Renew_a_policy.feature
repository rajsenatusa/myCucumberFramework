# Author: Can Yavas
# created on 04/24/2024
#TEST CASE NUMBER & TITLE: MTR-191: VOL HO4 Renew a policy
#Precondition: Active HO4  Policy
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter able to do manual renewal for VOL HO4 policy
#User: jbarnes, Standard Agent(AG1730A1)

@regression @mtr191 @ho4regression @gu 

Feature: MTR-191: VOL HO4 Renew a policy

  Scenario: Verify Underwriter able to do manual renewal for VOL HO4 policy
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr191>
    And User enters HO4 product selection information and effective date as current date
    And User enters all required information on HO4 quote screen with current date as prior policy date <mtr191>
    And User enters all required information on HO4 dwelling screen <mtr191>
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that HO4 policy has been created successfully and note policy number <mtr191>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr191>
    And User clicks Start Transaction
    And User selects Renewal
    And User process manual renewal on the policy <mtr191>
    Then User validates Renewal has been processed and validates Renewal tx on history chevron <mtr191>
    And User clicks Policy File Chevron <mtr191>
    And User validates Renewal Declaration Form Link is visible and completes test <mtr191>
    
    
    
    
    
    
    