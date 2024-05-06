# Author: Mustafa Cemek
# created on 03/15/2024
#TEST CASE NUMBER & TITLE: MTR221_Reinstate a policy _ FAIB
#Precondition-Reinstate a policy with lapse_FAIB
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validate, System should process the Reinstatement without any  lapse
#User:agent, underwriter
@regression @mtr221 @gu  
Feature: MTR-221_Reinstate a policy _ FAIB

  Scenario: Validate, Underwriter can process the Reinstatement
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for AIB and current effective date <221>
    And User enters all required information on AIB quote screen
    And User selects liability coverage on quote screen
    And User adds operator information on quote screen
    And User enters all required information on AIB boat dwelling screen
    And User enters all required information on AIB review screen
    And User creates AIB application
    And User answers all underwriting questions for AIB
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that AIB policy has been created successfully and takes note of the policy number for <mtr221>
    And User clicks Start Transaction <mtr219>
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr219>
    And User selects Boat Sold as reason <mtr221>
    And User sets the effective date as after 2 months from the current date
    And User clicks Process <mtr219>
    Then User validates that AIB policy has been canceled successfully
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr221>
    Then User validates that AIB policy has been canceled successfully
    And User clicks Start Transaction
    And User selects Reinstatement and validates <mtr219>
