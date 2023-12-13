#Author: Can Yavas
##created on 10/23/2023

# TEST CASE NUMBER & TITLE: TC 16598--DP3 UWMgr NB End (FLOOD) RN (2) and Claim Forms Basic w/ ALL additional/optional coverages
# PRECONDITIONS (IF ANY)
# HIGH LEVEL STEPS OF TEST SCRIPT:  Create new business by including all additional/ optional coverages,
#  								add Flood coverage over endorsement transaction, 
# 									Create a claim on the policy and perform renewal
# EXPECTED RESULTS: All forms will be verified in the following states: 
# New Business
# Endorsement
# Claims
# Renewal transactions
 
# User: jbarnes , admin

#NOTE: IT's failing once adding flood coverage. There is a defect created on 12/04/23 (MRT-35)

@regression @tc16598 @mtr2490 @dp3regression
Feature: TC 16598--DP3 UWMgr NB End (FLOOD) RN (2) and Claim Forms Basic w/ ALL additional/optional coverages

  Scenario: All forms will be verified in the following states
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr2490>
    And User enters DP3 product selection information and effective date as current date plus 30 days <mtr2490>
    And User enters all required information on DP3 quote screen with current date plus 30days as prior policy date <mtr2490>
    And User enters all required information on DP3 dwelling screen <mtr2490> and selects additional coverages and adds additional options
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User updates roof material on dwelling screen
    And User finalizes transaction for <mtr2490>
    And User issues policy
    And User validates that DP3 policy has been created successfully and takes note of policy number <mtr2490>
    And User clicks Forms Chevron <mtr2490>
    And User validates all expected forms is visible on forms screen <mtr2490>
    And User validates greeting letter form version <mtr2490>
    And User validates privacy statement form version <mtr2490>
    And User validates Limitations on Roof Coverage form version <mtr2490>
    And User validates Deductible Notification Options form version <mtr2490>
    And User validates Policy Jacket form version <mtr2490>
    And User validates Dwelling Property 3 Special form version <mtr2490>
    And User validates Dwelling Property 3 Basic form version <mtr2490>
    And User validates Special Provisions for Florida form version <mtr2490>
    And User validates Calendar Year Hurricane Deductible Requirement form version <mtr2490>
    And User validates Home Cyber Protection Coverage form version <mtr2490>
    And User validates Home Systems Protection Service Line Coverage form version <mtr2490>
    And User validates Identity Recovery Coverage form version <mtr2490>
    And User validates Limited Carport, Pool Cage and Screen Enclosure Coverage form version <mtr2490>
    And User validates Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage form version <mtr2490>
    And User validates Limited Theft Coverage form version <mtr2490>
    And User validates Loss Assessment Property Coverage form version <mtr2490>
    And User validates Ordinance or Law Coverage form version <mtr2490>
    And User validates Limited Water Damages form version <mtr2490>
    And User validates Personal Property Replacement Cost Coverage form version <mtr2490>
    And User validates Sinkhole Loss Coverage form version <mtr2490>
    And User validates Water Damage Exclusion form version <mtr2490>
    And User validates Outline of your Dwelling Policy form version <mtr2490>
    And User validates Checklist of Coverage form version <mtr2490>
    And User validates Notice of Premium Discounts for Hurricane Loss Mitigation form version <mtr2490>
    And User validates Notice of Consumer Reports Ordered and Information Used in Premium Determiniation form version <mtr2490>
    And User validates Sinkhole Loss Coverage Selection Rejection Form form version <mtr2490>
    And User clicks Policy File Chevron <mtr2490>
    And User clicks Application Link and validates form versions <mtr2490>
    And User clicks Policy File Chevron <mtr2490>
    And User clicks New Business Package Link and validates form versions <mtr2490>
    And User changes system date to endorsement date <mtr2490>
    And User searches for the policy number <mtr2490>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as endorse date and starts endorsement <mtr2490>
    And User clicks Dwelling Chevron <mtr2490>
    And User adds flood coverage
    And User clicks Finalize button and Endorses Policy <mtr2490>
    And User clicks Forms Chevron <mtr2490>
    And User validates all expected forms is visible on forms screen endorsement level<mtr2490>
    And User clicks Flood Information form and validates form version
    And User clicks Flood Coverage Endorsement Form and validates form version
    And User clicks Policy File Chevron <mtr2490>
    And User clicks Endorsement Package and validates form version <mtr2490>
    And User signs out
    And User login to Spin as Claim CSR
    And User changes system date to endorsement date <mtr2490>
    And User searches for the policy number <mtr2490>
    And User clicks Report Loss
    And User sets loss date as endorse date <mtr2490>
    And User selects loss cause as Collapse and clicks Save <mtr2490>
    And User completes all required information on claim chevron <mtr2490>
    And User clicks save and takes note of the loss number <mtr2490>
    And User clicks Complete and takes note of the claim number <mtr2490>
    And User clicks Forms Chevron <mtr2490>
    And User validates all expected forms is visible on forms screen endorsement level<mtr2490>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the policy number <mtr2490>
    And User clicks Make Payment and selects credit card and enters due amount <mtr2490>
    And User makes payment with Credit Card for <mtr2490>
		And User does Auto Renewal for the policy with batch jobs <mtr2490>
    And User clicks Forms Chevron <mtr2490>
    And User validates all expected forms is visible on forms screen endorsement level<mtr2490>
    And User clicks Policy File Chevron <mtr2490>
    And User clicks Renewal Declaration Form and validates form version <mtr2490>
    And User clicks Make Payment and do renewal payment <mtr2490>
    And User searches for renewed second term the policy number <mtr2490>
		And User clicks Start Transaction
    And User clicks Renewal Transaction Selection
    And User clicks Finalize button and completes renewal <mtr2490>
    And User searches third term manually renewed policy 
    And User clicks Forms Chevron <mtr2490>
    And User validates all expected forms is visible on forms screen endorsement level<mtr2490>
    And User clicks Policy File Chevron <mtr2490>
    Then User clicks Second Renewal Declaration and validate form version <mtr2490> and completes test
    
    
    
    
    
    
    
    
    
    
    
    