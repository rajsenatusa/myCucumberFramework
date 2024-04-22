##created on 04/24/2024 by Mustafa Cemek
## TEST CASE NUMBER & TITLE: MTR5332--IM-614 : AIB END Validate mailing address can be updated through copy to mailing address link
## PRECONDITIONS (IF ANY):
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create a NB AIB Policy with system/effective date = future date
## 2. After creating application, modify insured address
## 3. Click on copy to mailing address link, Click on copy to billing address link
## 4. Complete all required Underwriting Questions with an asterisk (*). fix.. message displays
## 5. Click modify application button
## 6. Answer all UW questions
## 7. Click finalize and issue policy
## EXPECTED RESULTS: 1. Verifying that when a user clicks on Copy to Mailing Address while on the application that the Location address is copied to the Mailing Address
## 2. Confirming that users are not allowed to proceed without answering the UW questions.
## User: Standard Agent
##PS: This fix has not been deployed to model and production. Planning to deploy April release. Please follow up before putting inside regression suite
@regression @mtr5332 @aibregression @im
Feature: MTR5332--IIM-614 : AIB END Validate mailing address can be updated through copy to mailing address link

  Scenario: Validate AIB mailing address can be updated through copy to mailing address link
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr5332>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr5332>
    And User enters AIB product selection information and current date as effective date
    And User enters all required information on AIB quote screen for <mtr5332>
    And User selects liability coverage on quote screen for <mtr5332>
    And User adds operator information on quote screen <mtr5332>
    And User enters all required information on AIB boat dwelling screen for <mtr5332>
    And User enters all required information on AIB review screen <mtr5332>
    And User creates AIB application
    And User answers all underwriting questions for AIB
    And User checks application dwelling screen and finalizes transaction
    And User takes note of the application number <mtr5332>
    And User submits the application for UW approval
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Application Number for <mtr5332>
    And User clicks approve button <mtr5332>
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Application Number for <mtr5332>
    And User issues policy
    Then User validates that AIB policy has been created successfully
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User selects endorsement date as system date plus 30 days
