#created on 12/5/2023 by Can Yavas

# TEST CASE NUMBER & TITLE: TC 16882--DP1 Standard Agent, NB, Occupancy Owner, DTC � Distance to Coast � Capacity testing
# PRECONDITIONS (IF ANY): Capacity Threshold is setup for Manatee county for Distance to Coast attribute for mentioned product.
 
# HIGH LEVEL STEPS OF TEST SCRIPT:  Verify for DP1 policy in Manatee County, agent gets information message "Cannot issue due to 
# limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review]".
# UW can take ownership of this quote and can issue the policy.
# EXPECTED RESULTS: An Agent user can not  issue the NB policy with validation message "Cannot issue due to limited catastrophic capacity 
# [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review]".
# But UW Manager can take ownership of this quote and can issue the policy. 
 
 
# User: AG1730, jbarnes, Gallopadmin


@regression @mtr4577 @dp1regression
Feature: TC 16882-MTR4577-DP1 Standard Agent, NB, Occupancy Owner, DTC Distance to Coast, Capacity testing

  Scenario: Validate or DP1 policy in Manatee County, agent gets information message Cannot issue due to limited catastrophic capacity
    Given User login to Spin as Admin Agent
    When User clicks Quote Policy Tab <mtr4577>
    And User clicks Capacity Maintenance <mtr4577>
    And User searches Manatee County 
    And User checks Capacity Rule has been set to Capacity is of 10 mi to less than 15 mi is set for DP1 DP3 HO3 MHO3 and adds capacity in case it has not been set
    And User login to Spin as Standard Agent
    And User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr4577>
    And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen <mtr4577>
    And User enters all required information on DP1 dwelling screen <mtr4577>
    And User validates 'Cannot issue due to limited catastrophic capacity Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review' message is visible
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User clicks Dwelling Chevron <mtr4577>
    And User checks application dwelling screen validates error message and finalizes transaction <mtr4577>
    And User validates error message displayed on closeout screen <mtr4577>
    And User takes note of the application number <mtr4577>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for application number <mtr4577>
    And User validates 'App is owned by AG1730' 'Application in inquiry mode only' labels are visible
    And User takes ownership of the application
    And User clicks Dwelling Chevron <mtr4577>
    And User validates error message displayed on dwelling screen <mtr4577>
    And User clicks Finalize button
    Then User issues policy and completes test <mtr4577>
    
    
    
    
    
    
    
    
    
    