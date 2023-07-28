#Author: Can Yavas
##created on 07/26/2023 
##steps in the original user story needs to be clarified. After clarification; code will be updated

@regression @tc16851
Feature: TC 16851--HO4 Agent AllowPayPlanChange

  
  Scenario Outline: Validate Agent is able to change bill plan within 5 days of policy effective date up to maximum 2 times
    #Given User login to Spin as Admin Agent
    #And User clicks Admin Tab 
    #And User clicks User Management Tab
    #And User searches Agent
    #And User clicks Search button
    #And User scrolls to User Roles List 
    #And User clicks Override Link on Policy Agent Standard
    #And User sets Number Days From Effective Date Allowed Pay Plan to <30> days
		#And User sets Number of Allowed Pay Plan to <3>
		#And User verifies allow pay plan change from policy switched to Yes
		#And User clicks save
		#And User signs out
		When User signin Spin with username "<user>" and password "<Pwd>"
		And User starts transaction as a new customer
		And User enters all required information on policy information screen
		And User enters HO4 product selection information and current day as effective date
		And User enters all required information on HO4 quote screen
		And User enters all required information on HO4 dwelling screen
		And User enters all required information on HO4 review screen
		And User creates HO4 application
		And User answers all underwriting questions for HO4
		And User checks application dwelling screen and finalizes transaction
		And User issues policy
		And User validates that HO4 policy has been created successfully and notes issued policy number and searches policy
		And User clicks Billing Tab
		And User gets next action date and changes system date to next action date
		And User searches policy
		And User clicks Billing Tab
		And User changes Pay Plan to <8 Payment Plan>
		And User makes Credit Card payment
		And User searches policy on Payment Tab
		#And User clicks Billing Tab
		#And User gets next action date and changes system date to second next action date
		#And User searches policy
		And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date plus <4> "Days" from current date
		And User clicks Review Chevron
		And User sets payplan to Automated ACH
		And User selects ACH quarterly
		And User enters required ACH information
		And User clicks Save
		And User clicks Finalize button
		And User completes endorsement transaction
		And User changes system date <35> days forward from current date
		And User searches policy
		And User clicks Billing Tab
	 #And User verifies Change Pay Plan Not Visible
	 #And User clicks Start Transaction
	 #And User clicks EN Transaction Selection
	 #And User selects endorsement eff date 
	 #And User clicks Review Chevron
	 #And User verifies pay plan type is disabled
	 #And User clicks Cancel Transaction
	 #And User changes system date <15> days forward from current date
	 #And User searches policy
	 #And User clicks Billing Tab
	 #And User clicks Change Pay Plan
	 #And User sets Direct Bill as Pay Plan
	 #And User clicks process
   #Then User verifies Pay Plan is visible before <30> days
     
  Examples: Test Data 
  | user |  Pwd   |
  |AG0376|password|
 
