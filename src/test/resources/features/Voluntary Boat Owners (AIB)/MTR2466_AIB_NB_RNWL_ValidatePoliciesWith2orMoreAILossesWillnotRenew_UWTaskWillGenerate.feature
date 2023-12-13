##created on 11/06/2023 by Can Yavas

 # TEST CASE NUMBER & TITLE: MTR2466--AIB Validate boat policies with 2 or more AI claims will not renew and UW task will be generated
 # PRECONDITIONS (IF ANY
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Validating boat policies with 2 or more AI Claims do not renew with no issues
 # EXPECTED RESULTS: Validating boat policies with 2 or more AI Claims do not renew and UW task will be created
  
 # User: adjuster1 admin 


@regression @mtr2466 @aibregression
Feature: MTR2466--AIB Validate boat policies with 2 or more AI claims will not renew and UW task will be generated

  Scenario: Validating boat policies with 2 or more AI Claims do not renew and UW task will be created
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr2466>
		And User enters AIB product selection information and current date as effective date
    And User enters all required information on AIB quote screen for <mtr2466>
    And User selects liability coverage on quote screen for <mtr2466>
    And User adds operator information on quote screen <mtr2466>
    And User enters all required information on AIB boat dwelling screen for <mtr2466>
    And User enters all required information on AIB review screen
		And User creates AIB application
    And User answers all underwriting questions for AIB
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that AIB policy has been created successfully and takes note of the policy number <mtr2466>
    And User signs out
    And User login to Spin as Adjuster
    And User searches for Policy Number for <mtr2466>
    And User clicks Report Loss
    And User sets loss date as current date <mtr2466>
    And User selects loss cause as Collision and clicks Save
    And User selects vehicle, purpose of use and all required information on claim screen <mtr2466>
    And User clicks Complete and takes note of the claim number <mtr2466>
    And User searches for Policy Number for <mtr2466>
    And User clicks Report Loss
    And User sets loss date as current date <mtr2466>
    And User selects loss cause as Cracking and clicks Save
    And User selects vehicle, purpose of use and all required information on claim screen on second claim <mtr2466>
    And User clicks Complete and takes note of the claim number <mtr2466>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for Policy Number for <mtr2466>
    And User clicks Make Payment and selects credit card and enters due amount <mtr2466>
    And User makes payment with Credit Card for <mtr2466>
    And User searches for Policy Number for <mtr2466>
    And User clicks Task Tab and checks Show System Task and takes note of the preAutoDate
    And User changes system date to pre auto date
    And User renew policy through daily jobs manual <mtr2466>
    And User searches for Policy Number for <mtr2466>
    Then User validates UW task will generate and completes test
    
    
    
    
    
    
    
    
    
    