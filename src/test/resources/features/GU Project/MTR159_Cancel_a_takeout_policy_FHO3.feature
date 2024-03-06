## Author: Can Yavas
## created on 02/14/2024

## TEST CASE NUMBER & TITLE: MTR159--TO HO3, Verify Underwriter is able to Cancel policy  company & Pro-rate
## PRECONDITIONS (IF ANY): TO HO3 NB 
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into SPIN as Underwriter
## 2.Enter policy number in Search field
## 3.Select Start Transaction from Actions tile
## 4.Select Cancellation
## EXPECTED RESULTS: Cancellation should process  

## User: jbarnes, Admin 


@regression @mtr159 @gu
Feature: MTR159--TO HO3, Verify Underwriter is able to Cancel policy  company & Pro-rate

  Scenario: Validate Cancellation should process with UW user

    Given User login to Spin as Admin Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr159>
    And User enters product selection information for TOHO3 and sets effective date as current date
    And User enters all required information on TOHO3 quote screen <mtr159>
    And User enters all required information on TOHO3 dwelling screen <mtr159>
    And User enters all required information on TOHO3 review screen
    And User creates TOHO3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects dwelling type and roof material
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr159>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr159>
    And User clicks Start Transaction
    And User selects Cancellation 
    And User selects Cancellation Type as Company <mtr159>
    And User selects Material misrepresentation in obtaining the policy as reason <mtr159>
    And User sets eff date current date minus 1 day and validates error message <mtr159>
    And User clicks Start Transaction
    And User selects Cancellation 
    And User selects Cancellation Type as Company <mtr159>
    And User selects Material misrepresentation in obtaining the policy as reason <mtr159>
    And User selects pro rate as cancel type and process transaction <mtr159>
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User validates Policy Status displayed as Cancelled <mtr159>
    And User clicks Policy File Chevron <mtr159>
    Then User validates Cancellation Confirmation form listed and validates form <mtr159>
    
    
    
    
    
    
    
    