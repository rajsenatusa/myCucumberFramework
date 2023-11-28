#Author: Can Yavas
##created on 11/28/2023

 # TEST CASE NUMBER & TITLE: AIB, Service fee is applied when Total Annual Policy Premium is greater than $2000 
 # PRECONDITIONS (IF ANY) :Application with Total Annual Policy Premium that is between $2000 - 2999.99
  
 # HIGH LEVEL STEPS OF TEST SCRIPT:  1. Validate Direct Bill 8 Pay Plan has service fee of $6
 #                                   2. Increase premium to next pay tier.
 #                                   3. Validate service fee is still applied to application
 #                                   4. Issue NB
 # EXPECTED RESULTS: Service fee is applied on tiers > $2000
   
 # User: gallopadmin


@regression @tc34421
Feature: TC 34421-AIB, Service fee is applied when Total Annual Policy Premium is greater than $2000 

  Scenario: Validating that Service fee is applied on tiers over $2000
    Given User login to Spin as Admin Agent
		When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc34421>
		And User enters AIB product selection information and current date as effective date
		And User enters all required information on AIB quote screen for <tc34421>
		And User selects liability coverage on quote screen for <tc34421>
		And User adds operator information on quote screen <tc34421>
		And User enters all required information on AIB boat dwelling screen for <tc34421>
		And User adds second and third boat through copying links and clicks review Chevron
		And User enters all required information on AIB review screen <tc34421>
		And User creates AIB application
		And User answers all underwriting questions for AIB
		And User clicks Review Chevron and selects 8 pay plan
		And User validates service fee amounts
		And User checks application dwelling screen and finalizes transaction
		Then User issues policy and close unnecessary tabs and taking note of the policy number and completes test <tc34421>
		
		
		
		
		
		
		
		
		
		
		