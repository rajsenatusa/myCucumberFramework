#Author: Can Yavas
##created on 08/31/2023

 ## TEST CASE NUMBER & TITLE: TC 35243--UW, TODP3, Validate when open Company cancellation is completed that it also applies the cancellation to the renewal term
 ## PRECONDITIONS (IF ANY
 ## HIGH LEVEL STEPS OF TEST SCRIPT:  Validate when the open cancellation is completed that it also applies the cancellation to the renewal term
 ## EXPECTED RESULTS: When the open cancellation is completed that it also applies the cancellation to the renewal term
 
 ## User: Jlowe
 
@regression @mtr393
Feature: TC 35243--UW, TODP3, Validate when open Company cancellation is completed that it also applies the cancellation to the renewal term

  Scenario: Validate when the open cancellation is completed that it also applies the cancellation to the renewal term
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP3 and current date as effective date
    And User enters all required information on TODP3 quote screen
    And User enters all required information on TODP3 dwelling screen
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects roof material
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TODP3 policy has been created successfully and take note of policy number
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr393>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Company
    And User selects Substantial Change in risk as reason <mtr393>
    And User selects Loss meets policy limits as subreason
    And User selects effective date as cancel date 'current date plus 30 days' <mtr393>
    And User selects pro rate as cancel type and process transaction <mtr393>
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User takes note of the application number <mtr393>  
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the policy number <mtr393>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr393>
    And User makes payment with Credit Card for <mtr393>
    And User does auto renewal through batch jobs <mtr393>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <mtr393>
    And User validates expected text messages
    And User clicks refresh button
    And User validates 'conflict with changes made to the policy since this application was started. Expand to review' message has been displayed
    And User finalizes transaction <mtr393>
    And User clicks process and close unnecessary tabs
    And User clicks cancelled policy and compare transaction status with expected value
    
    
