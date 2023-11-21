#Author: Can Yavas
##created on 11/01/2023

 # TEST CASE NUMBER & TITLE: TC 16720--TOMHO3, UWMgr: End (Wind/Hail Excl) , Claim RN(2) Forms: NOC Assignment Agreement Notice
 # PRECONDITIONS (IF ANY)
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Create new business effective 07/20/2019,
 # 									Endorse policy by adding WindHail exclusion,
 #  								Renew the policy where NOC will be generated on term-1,
 #  								The NOC will expire on term-2 renewal
 # EXPECTED RESULTS: NOC form attached accordingly as per renewal. 
  
 # New Business
 # Endorsement
 # Claims
 # Renewal transactions
  
 # User: Gallopadmin

@regression @tc16720 @MTR4461
Feature: TC 16720-MTR4461-TOMHO3, UWMgr: End (Wind/Hail Excl) , Claim RN(2) Forms: NOC Assignment Agreement Notice

  Scenario: Validate that NOC form attached accordingly as per renewal 
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16720>
    And User enters product selection information for TOMHO and current date minus 1 year as effective date <tc16720>
    And User enters all required information on TOMHO quote screen <tc16720>
    And User enters all required information on TOMHO dwelling screen <tc16720>
    And User enters all required information on TOMHO review screen
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron <tc16720>
    And User completes required information on dwelling screen <tc16720>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOMHO policy has been created successfully and takes note of the policy number <tc16720>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to policy effective date plus 30 days <tc16720>
    And User searches for the policy number <tc16720>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as endorsement date and starts endorsement <tc16720>
    And User clicks dwelling chevron <tc16720>
    And User checks Wind Hail exclusion
    And User finalizes transaction and completes endorsement <tc16720>
    And User clicks Forms Chevron <tc16720>
    And User validates 'HO 04 94 06 97' form is visible on forms chevron and validates form version
    And User clicks Policy File Chevron <tc16720>
    And User clicks Endorsement Package and validate form version <tc16720>
    And User signs out
    And User login to Spin as Claim CSR
    And User changes system date to policy effective date plus 30 days <tc16720>
    And User searches for the policy number <tc16720>
    And User clicks Report Loss
    And User sets loss date as endorse date <tc16720>
    And User selects loss cause as collapse and clicks Save <tc16720>
    And User completes all required information on claim chevron <tc16720>
    And User clicks save and takes note of the loss number <tc16720>
    And User clicks Complete and takes note of the claim number <tc16720>
    And User clicks Financial Actions Tab 
    And User clicks Start Claim button
    And User clicks Claims Icon
    And User clicks Adjust Reserves
    And User finalizes transaction and process transaction <tc16720>
    And User clicks Forms Chevron <tc16720>
    And User validates 'HO 04 94 06 97' form is visible on forms chevron <tc16720>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the policy number <tc16720>
    And User clicks Make Payment and selects credit card and enters due amount <tc16720>
    And User makes payment with Credit Card for <tc16720>
		And User does Auto Renewal for the policy with batch jobs <tc16720>
    And User searches for the renewed policy number <tc16720>
    And User clicks Forms Chevron <tc16720>
    And User validates 'HO 04 94 06 97' form and Assignment Agreement Notice 01 19 form is visible on forms chevron <tc16720>
    And User clicks Assignment Agreement Notice form and validates form version <tc16720>
    And User clicks Policy File Chevron <tc16720>
    And User clicks Renewal Declaration and validates form version <tc16720>
    And User clicks Make Payment and do renewal payment <tc16720>
    And User does second Auto Renewal for the policy with batch jobs <tc16720>
    And User clicks Forms Chevron <tc16720>
    Then User validates 'HO 04 94 06 97' form is visible and Assignment Agreement Notice 01 19 form is not visible on forms chevron <tc16720>
    