 #created on 12/19/2023 by Can Yavas

 # TEST CASE NUMBER & TITLE: TC 16879--HO6 Standard Agent, NB, Occupancy Owner, DTC  Distance to Coast  Capacity testing
 # PRECONDITIONS (IF ANY): Capacity Threshold is setup for Manatee county for Distance to Coast attribute for mentioned product.
  
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Verify for HO6 policy in Manatee County, agent gets information message "Cannot issue due to 
 # limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review]".
 # UW can take ownership of this quote and can issue the policy.
 # EXPECTED RESULTS: An Agent user can not  issue the NB policy with validation message "Cannot issue due to limited catastrophic capacity 
 # [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review]".
 # But UW can take ownership of this quote and can issue the policy. 
   
 # User: AG1730


@regression @tc16879 @ho6regression
Feature: TC 16879--HO6 Standard Agent, NB, Occupancy Owner, DTC  Distance to Coast  Capacity testing

  Scenario: Validate that HO6 policy in Manatee County, agent gets information message Cannot issue due to limited catastrophic capacity
    Given User login to Spin as Admin Agent
    When User clicks Quote Policy Tab <tc16879>
    And User clicks Capacity Maintenance <tc16879>
    And User searches Manatee County 
    And User checks Capacity Rule has been set to Capacity is of 10 mi to less than 15 mi is set for HO6 and adds capacity in case it has not been set
    And User login to Spin as Standard Agent
    And User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16879>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <tc16879>
    And User enters all required information on HO6 dwelling screen <tc16879>
    And User enters all required information on HO6 review screen  
    And User creates HO6 application and validates expected issue messages
    And User answers all underwriting questions for HO6 and validates expected issue messages <tc16879>
    And User checks application dwelling screen and finalizes transaction and validates expected issue messages <tc16879>
    And User sets payment type and validates expected issue messages <tc16879>
    And User takes note of the application number <tc16879>
    And User signs out <tc16879>
    And User login to Spin as Underwriter Clerk
    And User searches for application number <tc16879>
    And User validates 'App is owned by AG1730' 'Application in inquiry mode only' labels are visible <tc16879>
    And User takes ownership of the application
    And User clicks Dwelling Chevron <tc16879>
    And User clicks Finalize button
    Then User issues policy and completes test <tc16879>
    
    
    
    
    
    
    
    
    
    
    