# Author: Mustafa Cemek
# created on 12/15/2023
#TEST CASE NUMBER & TITLE: TC 16890--HO6 - UW - Non-Renewals and Rescind Non-Renewal ( 124 & 125 Days from Expiration), Continuation of Coverage form
#PRECONDITIONS (IF ANY): Current HO6  policy
#HIGH LEVEL STEPS OF TEST SCRIPT:  UW can Non Renew a policy upto 125 day from Policy Expiration Date.
#Then the user can rescind the non renewal transaction  and form Continuation of Coverage form is attached.
#EXPECTED RESULTS: UW can Non Renew a policy upto 125 day from Policy Expiration Date.Then the user can rescind the non renewal transaction and form Continuation of Coverage form is attached.
#The UW cannot Non Renew the policy on 124 day from Policy Expiration Date, gets message -'Transaction must occur within the allowed Non-Renewal Request date range'
#User: UW(Jlowe)
@regression @tc16890
Feature: TC 16890--HO6 - UW - Non-Renewals and Rescind Non-Renewal (124 & 125 Days from Expiration)

  Scenario: TC16890_HO6_ValidateNonRenewalsRescindNonRenewalContinuationOfCoverage
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16890>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <tc16890>
    And User enters all required information on HO6 dwelling screen for <tc16890>
    And User enters all required information on HO6 review screen
    And User validates Quote Made for <tc16890>
    And User creates HO6 application
    And User answers all underwriting questions for <tc16890>
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User takes note of the Policy Number for <tc16890>
    And User signs out
    And User login to Spin as Underwriter
    And User changes date transaction to exp.date minus <125> days for <tc16890>
    And User searches for Policy Number for <tc16890>
    And User clicks Start Transaction
    And User clicks Non-Renewal Transaction Selection
    And User selects 'Failure to comply with underwriting requirements' as reason
    And User process transaction and clicks plus sign and validates UW reason message has been displayed
    And User clicks Start Transaction
    And User clicks Non-Renewal Rescind Transaction Selection
    And User validates 'Failure to comply with underwriting requirements;  additional information required for underwriting review not provided.' message has been displayed
    And User clicks Start and process transaction
    And User clicks Policy File Tab
    And User clicks Expand Button for Rescission of Non-Renewal Notice
    And User clicks 'Rescission of Non-Renewal Notice' form
    And User switches the form, saves form and does comparision with expected texts
    And User changes date transaction to exp.date minus <124> days for <tc16890>
    And User searches for Policy Number for <tc16890>
    And User clicks Start Transaction
    And User clicks Non-Renewal Transaction Selection
    And User selects 'Failure to comply with underwriting requirements' as reason
    And User validates 'Transaction must occur within the allowed Non-Renewal Request date range' label has been displayed
