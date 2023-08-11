#Author: Can Yavas
##created on 08/09/2023

@regression @tc16846
Feature: TC 16846--HO6, Diamond Agent, BillPlanChange

  Scenario: As an agent change bill plan several times throughout the life cycle of the policy
    Given User login to Spin as Diamond Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date
 		And User enters all required information on HO6 dwelling screen and enters <35.000> for CovC
 		And User enters all required information on HO6 review screen and selects <8> payment plan
 		And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User adds additional interests for first mortgagee
    And User finalizes transaction and complete credit card payment and issues policy
    And User validates that HO6 policy has been created successfully
    And User takes note of the policy number for <tc16846>
    Then User signs out
    And User login to Spin as Admin Agent
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User takes note of the next action date and run daily jobs
    And User signs out
    And User login to Spin as Diamond Agent
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User takes note of the second next action date and changes system date to second next action date
    And User searches policy and changes payment plan as quarterly and clicks process
    And User takes note of the third next action date
    And User signs out
    And User login to Spin as Admin Agent
    And User runs daily jobs on third next action date
    And User searches for Policy Number for <tc16846> 
    And User clicks Billing Chevron
    And User takes note of the fourth next action date
    And User signs out
    And User login to Spin as Diamond Agent
    And User changes system date to fourth next action date
    And User searches policy and changes payment plan as Mortgagee Bill and clicks process
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User takes note of the fifth next action date and run daily jobs
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User takes note of the sixth next action date
    And User signs out
    And User login to Spin as Diamond Agent
    And User changes system date to sixth next action date
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User changes pay plan as automated credit card and clicks process
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User takes note of the seventh next action date and run daily jobs
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User takes note of the eigth next action date and run daily jobs
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User takes note of the nineth next action date and run daily jobs
    And User signs out
    And User login to Spin as Diamond Agent
    And User searches for Policy Number for <tc16846>
    And User clicks Billing Chevron
    And User takes note of the tenth next action date and changes system date to tenth next action date
    And User searches for Policy Number for <tc16846>
    And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as tenth next action date
		And User clicks Review Chevron select Direct Full Payment and completes endorsement
    And User validates that Endorsement transaction has been completed successfully
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for Policy Number for <tc16846>
    And User clicks Make Payment for <tc16846> and selects credit card and enters due amount
    And User searches for Policy Number for <tc16846>
    And User clicks Task Tab
    And User clicks Show All and checks show system task and take note preautorenew and autorenew dates
    And User does auto renewal on policy
    And User signs out
    And User login to Spin as Diamond Agent
    And User changes system date as autoRenew date and changes pay plan as <8 Pay Plan>
    
    
    
    