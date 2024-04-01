##created on 03/25/2024 by Can Yavas
## TEST CASE NUMBER & TITLE: MTR533--DP3 - Verify DP3 policy , Mortagee Bill policy cancels 90 days after premium changing ENDO
## PRECONDITIONS (IF ANY): Active DP3 Policy
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create a NB Policy with system/effective date = current date and is Mortagee Bill
## 2. Advance system date to current date + 25 days
## 3. Create an ENDO to Increase CovA
## 4. Run batch jobs
## 5. Change Sytem date to equal the Next Action date (current date + 60 days)
## 6. Run batch jobs
## 7. Navigate back to policy billing tab and validate 1. Reminder Notice is generated 2. Next Action date = current date + 75
## 8. Change Sytem date to equal the Next Action date (current date + 75 days)
## 9. Run batch jobs
## 10. Navigate back to policy billing tab and validate 1. Legal Notice generates 2. Next Action date = current date +90 3. Cancel Notice is seen on Policy Summary tile
## 11. Change Sytem date to equal the Next Action date (current date + 90 days)
## 12. Run batch jobs
## 13. Navigate back to policy billing tab and validate 1. Flat Cancellation generates 2. Next Action date = None 3. Cancelled is seen on Policy Summary tile

## EXPECTED RESULTS: Validate that DP3, Admin, Mortagee Bill policy cancels 90 days after premium changing ENDO
## User: Admin

@regression @mtr533 @dp3regression @gu
Feature: MTR533--DP3 - Verify DP3 policy , Mortagee Bill policy cancels 90 days after premium changing ENDO

  Scenario: Validate that DP3, Admin, Mortagee Bill policy cancels 90 days after premium changing ENDO
    Given User login to Spin as Admin Agent
		And User changes system date to current date <mtr533>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr533>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr533>
    And User enters all required information on DP3 dwelling screen <mtr533>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User clicks Additional Interest Chevron
    And User clicks Add Additional Interest button
    And User completes required information on add additional interests screen and add first mortgagee <mtr533>
    And User checks application dwelling screen, selects mortgagee bill and finalizes transaction <mtr533>
    And User issues policy
    And User validates that DP3 policy has been created successfully and closes unnecessary tabs <mtr533>
    And User changes system date to current date plus 25 days <mtr533>
    And User searches for the policy number <mtr533>
    And User clicks Start Transaction
    And User selects Endorsement
    And User selects endorsement date as current date plus <25> days <mtr533>
    And User clicks Dwelling Chevron for <mtr533>
    And User increases CovA <mtr533>
    And User clicks finalize transaction
    And User endorses policy <mtr533>
    And User clicks Billing Chevron
    And User takes note of next action date and run daily jobs <mtr533>
    And User searches for the policy number <mtr533>
    And User clicks Billing Chevron
    And User validates next action date as endorsement date plus 60 days and run daily jobs <mtr533>
    And User searches for the policy number <mtr533>
    And User clicks Billing Chevron
    And User validates next action date as endorsement date plus 75 days and run daily jobs <mtr533>
    And User searches for the policy number <mtr533>
    And User clicks Billing Chevron
    And User validates next action date as endorsement date plus 90 days validates cancellation notice generated and run daily jobs <mtr533>
    And User searches for the policy number <mtr533>
    And User clicks Billing Chevron
    Then User validates next action date as None and validates flat cancellation generated, completes test <mtr533>
    
    