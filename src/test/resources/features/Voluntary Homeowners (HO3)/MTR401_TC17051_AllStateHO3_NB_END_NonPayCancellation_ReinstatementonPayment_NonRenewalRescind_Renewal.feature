##created on 09/05/2023 by Can Yavas

 ## TEST CASE NUMBER & TITLE: TC 17051--Allstate Agent test case: HO3, Allstate - New Business Endorsement - NonPay Cancellation - Reinstatement on Payment - Non Renewal/Rescind - Renewal
 ## PRECONDITIONS (IF ANY)
 ## HIGH LEVEL STEPS OF TEST SCRIPT:  
 ## EXPECTED RESULTS: All forms will be verified in the following states: 
 ## New Business
 ## Endorsement
 ## NonPay Cancellation
 ## Reinstatement on Payment
 ## Non Renewal/Rescind
 ## Renewal transactions
  
 ## User: AGISA006955

@regression @mtr401 @ho3regression
Feature: TC 17051--Allstate Agent test case: HO3, Allstate - New Business Endorsement - NonPay Cancellation - Reinstatement on Payment - Non Renewal/Rescind - Renewal

  Scenario: Validate All forms will be verified in the following states
    Given User login to Spin as Admin Agent
		And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent <AGISA002537>
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Override Link on Policy Agent Standard
    And User sets Yes for 'Allow user to view Consent to Rate Fields' and 'Allow user to edit Consent to Rate Fields' fields
    And User clicks save
		And User signs out
		And User login to Spin as AllState Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr401>
    And User enters HO3 product selection information and current date as effective date <mtr401>
		And User enters all required information on HO3 quote screen <mtr401>
		And User enters all required information on HO3 dwelling screen <mtr401>
		And User clicks consent to rate
		And User sets consent to rate value as '$100.000'
		And User clicks review Chevron and selects 8 Pay payment plan <mtr401>
		And User clicks correspondance tab
		And User selects 'Insurance Quote' from dropdown
		And User validates 'Agent Name' label is visible 
		And User clicks preview correspondance button
		And User validates form version on quote ui
		And User clicks process correspondance button and validates form version
		And User clicks Policy File Chevron <mtr401>
		And User clicks Insurance Quote Link and validates form version
		And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
		And User sets dwelling type, sets roof update and roof material
		And User clicks correspondance tab
		And User selects 'Application' from dropdown
		And User clicks preview correspondance button
		And User validates form version on application ui
		And User clicks Process Correspondance and validates quote and agent information in forms
		And User finalizes transaction for VOL HO3
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr401>
		And User clicks Policy File Chevron <mtr401>
		And User clicks Application Link and validates application form version
		And User clicks New Business Invoice Link and validates information in form
	  And User clicks Declaration Link and validates information in the form
	  And User searches for the policy number <mtr401>
		And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date and starts endorsement <mtr401>
		And User clicks Finalize button and Endorses Policy <mtr401>
		And User clicks Policy File Chevron <mtr401>
		And User clicks Endorsement Package Link and validates information in the form
		And User clicks correspondance tab
		And User selects 'Statement of No Loss' from dropdown
		And User clicks Process Correspondance
		And User clicks Policy File Chevron <mtr401>
		And User clicks Statement of No Loss Link and validates information in the form
		And User signs out
		And User login to Spin as Underwriter Clerk
		And User searches for the policy number <mtr401>
		And User clicks correspondance tab
		And User selects 'Agent Letter' from dropdown
		And User sets data for text box 
		And User clicks Process Correspondance and validates information in the form
		And User clicks correspondance tab
		And User selects 'Sinkhole Denial' from dropdown
		And User validates 'Agent Name' label is visible
		And User clicks Process Correspondance and validates information in the sinkhole loss form
		And User clicks Policy File Chevron <mtr401>
		And User clicks Agent Letter Link and validates information in the form
		And User clicks Policy File Chevron <mtr401>
		And User clicks Sinkhole Denial Link and validates information in the form
		And User signs out
		And User login to Spin as Admin Agent
		And User searches for the policy number <mtr401>
		And User clicks Billing Tab <mtr401>
		And User gets next action date and changes system date to next action date <mtr401>
		And User forward policy through batch jobs
		And User searches for the policy number <mtr401>
		And User validates 'Cancellation Notice' label is visible
		And User clicks Billing Tab <mtr401>
		And User gets second next action date and changes system date to second next action date <mtr401>
		And User forward policy through batch jobs
		And User searches for the policy number <mtr401>
		And User validates 'Cancellation Notice' label is visible
		And User clicks Policy File Chevron <mtr401>
		And User clicks Cancellation Notice Link and validates information in the form
		And User clicks Policy File Chevron <mtr401>
		And User clicks Cancellation Confirmation Link and validates information in the form
		And User clicks Billing Tab <mtr401>
		And User gets minimum amount for reinstatements 
		And User clicks Make Payment and selects credit card and enters minimum amount for reinstatements
    And User makes payment with Credit Card for <mtr401>
		And User validates Payment Confirmation form
		And User searches for the policy number <mtr401>
		And User forward policy through batch jobs
		And User searches for the policy number <mtr401>
		And User validates 'Active' 'Reinstatement' 'Reinstated' 'Cancellation' 'Cancellation Notice' labels are visible
		And User clicks Policy File Chevron <mtr401>
		And User clicks Continuation of Coverage Link and validates information in the form
		And User searches for the policy number <mtr401>
		And User clicks Start Transaction
    And User clicks Non Renewal Transaction Selection
		And User selects 'Failure to comply with underwriting requirements' as reason <mtr401>
		And User selects 'Additional information required for underwriting review not provided' as subreason
		And User clicks add button and starts and process transaction
		And User clicks Policy File Chevron <mtr401>
		And User clicks Non-Renewal Notice Link and validates information in the form
		And User searches for the policy number <mtr401>
		And User clicks Start Transaction
		And User clicks Non Renewal Rescind Transaction Selection
		And User clicks Start and process transaction
		And User clicks Policy File Chevron <mtr401>
		And User clicks Rescission of Non-Renewal Notice Link and validates information in the form
		And User searches for the policy number <mtr401>
		And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date and starts endorsement <mtr401>
    And User clicks Additional Interests Chevron
		And User completes required information on add additional interests screen
		And User clicks Review Chevron
		And User changes pay plan to Mortgagee
		And User clicks Finalize button and Endorses Policy <mtr401>
		And User searches for the policy number <mtr401>
		And User clicks Start Transaction
    And User clicks Renewal Transaction Selection
		And User clicks Finalize button and completes renewal <mtr401>
		And User clicks Policy File Chevron <mtr401>
		And User clicks Renewal Declaration Link and validates information in the form
		Then User clicks Renewal Invoice Link and validates information in the form and completes test
		
		
		
		
		
		
		
		
		