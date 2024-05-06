#Author: Can Yavas
##created on 08/14/2023

@regression @mtr1411 @dp1regression
Feature: TC 34253--DP1, UW, Approvals 'Allow to Approve Age of Plumbing attribute'

  Scenario: Validate that Uw can approve the application when Allow to Approve Age of Plumbing attribute = Yes
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen with old address
    And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen with current date as prior policy date <mtr1411>
    And User clicks OK for the message "Roof Cover has been changed to FBC Equivalent."
		And User enters all required information on DP1 dwelling screen for <mtr1411>
		And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen, sets Electrical and HVAC Updated as <2008> 
    And User validates 'Risk is ineligible due to age of Plumbing' message has been displayed
    And User finalizes transaction
    And User validates 'Risk is ineligible due to age of Plumbing' is visible on closeout screen
    And User validates 'Submit For Approval' is visible on closeout screen
    And User validates 'Modify Application' is visible on closeout screen
    And User takes note of the application number for <mtr1411>
    And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Admin Agent
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Underwriter
    And User clicks Search button
    And User scrolls to User Roles List
    And User clicks Override Link on Underwriter Role <mtr1411>
    And User override Underwriters 'Allow to Approve Age of Plumbing' as no
    And User signs out
    And User login to Spin as Underwriter
    And User searches for application number
    And User validates 'Issue New Business' is not visible on closeout screen
    And User validates 'Approve' is not visible on closeout screen
    And User validates 'Submit for Approval' is visible on closeout screen
    And User validates 'Modify Application' is visible on closeout screen
    And User validates 'Pending Approval' is visible on closeout screen
    And User signs out
    And User login to Spin as Admin Agent
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Underwriter
    And User clicks Search button
    And User scrolls to User Roles List
    And User clicks Override Link on Underwriter Role <mtr1411>
    And User override Underwriters 'Allow to Approve Age of Plumbing' as yes
    And User signs out
    And User login to Spin as Underwriter
    And User searches for application number
    And User validates 'Issue New Business' is visible on closeout screen
    And User validates 'Approve' is visible on closeout screen
    And User validates 'Submit For Approval' is not visible on closeout screen
    And User validates 'Pending Approval' is visible on closeout screen
    And Underwriter User clicks Approve Button
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for application number
    And User selects payment type and issues policy
    
    
    
    