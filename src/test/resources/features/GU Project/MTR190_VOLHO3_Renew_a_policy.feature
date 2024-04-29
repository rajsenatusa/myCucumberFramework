# Author: Can Yavas
# created on 04/24/2024
#TEST CASE NUMBER & TITLE: MTR-190: VOL HO3 Renew a policy
#Precondition: Active HO3  Policy
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter able to do manual renewal for VOL HO3 policy
#User: jbarnes, Standard Agent(AG1730A1)

@regression @mtr190 @ho3regression @gu 

Feature: MTR-190: VOL HO3 Renew a policy

  Scenario: Verify Underwriter able to do manual renewal for VOL HO3 policy
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr190>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr190>
    And User enters all required information on HO3 dwelling screen <mtr190>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr190>
    And User finalizes transaction for VOL HO3 <mtr190>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr190>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr190>
    And User clicks Start Transaction
    And User selects Renewal
    And User process manual renewal on the policy <mtr190>
    Then User validates Renewal has been processed and validates Renewal tx on history chevron <mtr190>
    And User clicks Policy File Chevron <mtr190>
    And User validates Renewal Declaration Form Link is visible and completes test <mtr190>
    
    
    
    
    
    
    