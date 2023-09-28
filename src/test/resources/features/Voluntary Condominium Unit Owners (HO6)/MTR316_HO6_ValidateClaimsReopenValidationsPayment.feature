##created on 09/22/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR316--HO6 Adj I NB, Claims Reopen Validations 'Claim status change with void payment validation'
## PRECONDITIONS (IF ANY): Current HO6  policy
## HIGH LEVEL STEPS OF TEST SCRIPT:  A user changes the status of a claim, makes a payment then a stop pay on the claim
## EXPECTED RESULTS:  Adjuster I can create a claim, can change the status of a claim from open to closed to reopen status, 
## can make a payment on a claim and needs approval to stop a payment on a claim.
  
## User: rvanhorn

##There is previously created defect for this test case. Will be observed for successful run. Upcoming steps have not been written. Left on line 372
##"Refer defect#1336- Perform a Payment release (Payables->Payment release) 
## Run the Initiate stats Job-> Update System Check Action, Start a transaction and stop the payment. Run the job Update System Check Action");

@regression @mtr316
Feature: MTR316--HO6 Adj I NB, Claims Reopen Validations 'Claim status change with void payment validation'

  Scenario: Validate Adjuster can create a claim, can change the status of a claim from open to closed to reopen status, can make a payment on a claim and needs approval to stop a payment on a claim. 
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr316>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <mtr316>
    And User enters all required information on HO6 dwelling screen and enters <35.000> for CovC <mtr316>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <mtr316>
    And User checks application dwelling screen and finalizes transaction <mtr316>
    And User issues policy
    And User validates that HO6 policy has been created successfully and takes note of the policy number <mtr316>
    And User signs out
    And User login to Spin as Adjuster
    And User searches for the policy number <mtr316>
    And User clicks Report Loss
    And User sets loss date as current date
    And User selects loss cause as <Collapse> and clicks Save
    And User completes all required information on claim chevron <mtr316>
    And User selects Examiner
    And User clicks save and takes note of the loss number <mtr316>
    And User clicks Complete and takes note of the claim number <mtr316>
    And User clicks Claim Information Link and validates expected information is visible
    And User clicks start transaction for the claim
    And User clicks Financial Actions Tab
    And User clicks Financial Actions Link
    And User adjusts reserves and sets indemnity Dwelling A as <3000> and Indemnity Cov C as <3000>
    And User clicks Finalize Transaction
    And User validates 'Maximum Reserve for Indemnity exceeded limit of $10,000.00' text is visible
    And User takes note of the transaction number
    And User clicks Submit For Approval button
    And User signs out
    And User login to Spin as Claims Manager
    And User searches Claim Number
    And User takes ownership of the claim transaction
    And User approves Claim Transaction
    And User signs out
    And User login to Spin as Adjuster
    And User searches Claim Number
    And User clicks Process button
    And User clicks start transaction for the claim
    And User clicks Financial Actions Tab
    And User clicks Claims Icon
    And User closes Reserves
    And User clicks Finalize Transaction
    And User clicks Process button
    And User clicks start transaction for the claim
    And User clicks Claims Icon
    And User clicks Adjust Reserves and sets Indemnity Dwelling A Item Limit
    And User clicks Finalize Transaction
    And User clicks Process button
    And User validates 'Reopen Reason is required for this transaction. Please select a reopen reason in order to process this transaction.' text is visible
    And User selects Reopen Reason as Other
    And User clicks Process button
    And User clicks start transaction for the claim
    And User clicks Claims Icon
    And User makes Claim Payment
    And User clicks Finalize Transaction
    And User clicks Process button
    
    
    
    
    
    
    