##created on 03/26/2024 by Can Yavas
## TEST CASE NUMBER & TITLE: MTR531--Verify DP1 policy , Agent can perform, END TX, Increase CovA, Change Deductible, Change 1st Mortgagee, UW Approval
## PRECONDITIONS (IF ANY): Active DP1 Policy
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create a NB Policy with system/effective date = current date 
## 2. Start Endorsement
## 3. Enter $ 650,000 for Cov A(Increase Cov A by 10%), Select "$2,500" for Deductible (AOP)* ,Select "5%" for the Deductible (Hurricane)*
## 4. Add Additional Interest as first mortgagee
## 5. Finalize transaction, validate issue messages and submit for approval
## 6. Login as Underwriter, retrieve application
## 7. Approve application, log out as uw
## 8. Log in as agent, retrieve application, complete endorsement, validate changes

## EXPECTED RESULTS: Validate that DP1 policy , Agent can perform, END TX, Increase CovA, Change Deductible, Change 1st Mortgagee, UW Approval
## User: Standard Agent, Underwriter1

@regression @mtr531 @dp1regression @gu 
Feature: MTR531--Verify DP1 policy , Agent can perform, END TX, Increase CovA, Change Deductible, Change 1st Mortgagee, UW Approval

  Scenario: Validate that DP1 policy , Agent can perform, END TX, Increase CovA, Change Deductible, Change 1st Mortgagee, UW Approval
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr531>
	 	When User starts transaction as a new customer
   	And User enters all required information on policy information screen <mtr531>
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date as prior policy date <mtr531>
	 	And User enters all required information on DP1 dwelling screen <mtr531>
		And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <mtr531>
    And User clicks Start Transaction
    And User selects Endorsement
    And User selects endorsement date as current date <mtr531>
    And User clicks Dwelling Chevron for <mtr531>
    And User increases CovA, selects deductible all perils as 2500, select hurricane ded as 5 <mtr531>
    And User clicks Additional Interest Chevron
    And User clicks Add Additional Interest button
    And User completes required information on add additional interests screen and add first mortgagee <mtr531>
    And User checks application dwelling screen and finalizes transaction <mtr531>
    And User validates issue messages on buttons on closeout screen <mtr531>
    And User takes note of the application for <mtr531>
    And User clicks submit for approval button for <mtr531>
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date <mtr531>
    And User searches for the application <mtr531>
    And User validates 'COV A change exceeding 10% Must be approved.' message displayed on issue tile <mtr531>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <mtr531>
    Then User endorses policy and completes test <mtr531>
    
    
    
    
    
    
    
    
    
    
    