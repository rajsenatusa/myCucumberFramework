#Author: Can Yavas
#created on 04/17/2024
#TEST CASE NUMBER & TITLE: MTR-5865 HO3 LFM2-2 Validation of Base Letter Template - Appraisal Rejection Letter (CMH) on a VOHO3 - Basic-Approved
#Precondition: Create a HO3 policy
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Verify User is able to create "Appraisal Rejection Letter (CMH)" on a VOHO3 claim and submitted Claim File
#User: Standard Agent, Adjuster1, wdennis

@regression @mtr5865 @lfm
Feature: MTR-5865 HO3 LFM2-2 Validation of Base Letter Template - Appraisal Rejection Letter (CMH) on a VOHO3 - Basic-Approved

  Scenario: Verify User is able to create Appraisal Rejection Letter_CMH on a VOHO3 claim and submitted Claim File
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr5865>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr5865>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr5865>
    And User enters all required information on HO3 dwelling screen <mtr5865>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5865>
    And User signs out
    And User login to Spin as Adjuster
    And User changes system date to current date <mtr5865>
    And User Searchs for Policy Number <mtr5865>
    And Use clicks Report Loss
    And User sets Loss Date as current date <mtr5865>
    And User fills all required information on claim notice screen and selects freezing as loss cause <mtr5865> 
    And User clicks Claim Overview Chevron <mtr5865>
    And User clicks More and starts transaction <mtr5865> 
    And User clicks first claimant and selects assigned adjuster
    And User clicks Correspondence Tab <mtr5865> 
    And User selects Correspondence Form Appraisal Rejection Letter CMH <mtr5865>
    And User validates Appraisal Rejection Letter CMH displayed on Draft Editor, takes screenshot and validate editable and non editable fields
    And User clicks Process Correspondence button <mtr5865> 
    And User validates "Claimant Appraisal Rejection Letter Interactive" template is displayed under Pending Correspondence section 
    And User clicks Claimant Appraisal Rejection Letter Template and validates information
    And User clicks Claim Overview Chevron <mtr5865> 
    And User clicks Finalize button 
    And User validates "Claimant Appraisal Rejection Letter Interactive" template is displayed under Pending Correspondence section 
    And User submits for approval and takes note of the transaction number <mtr5865>
    And User signs out
    And User login to Spin as Claims Manager
    And User clicks to Inbox <mtr5865>
    And User validates transaction submitted for approval with current transaction number
    And User clicks Work for that transaction and validate popup displayed with submitted note
    And User validates all expected buttons visible on closeout screen and approves transaction <mtr5865>
    And User clicks to Inbox <mtr5865>
    And User validates transaction submitted for approval with current transaction number not visible anymore
    And User signs out
    And User login to Spin as Adjuster
    And User clicks to Inbox <mtr5865>
    And User validates transaction is approved message with current transaction number
    And User clicks Work for that transaction and validate popup displayed with submitted note
    And User validates process, make changes, more buttons are visible and process transaction <mtr5865>
    And User clicks Claim File Chevron <mtr5865>
    Then User clicks Interactive Appraisal Rejection Letter and validates form version and completes test
    
    
    
    
    
    
    
    
    
    
    
    
     
     