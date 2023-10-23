#Author: Can Yavas
##created on 08/08/2023

 # TEST CASE NUMBER & TITLE: MTR2465 - HO6, UW, Task, 'Validate UW can create manual Task on a policy"
 # PRECONDITIONS (IF ANY):Active HO6 policy
  
 # HIGH LEVEL STEPS OF TEST SCRIPT: Underwriter can create manual UW task for all the listed tasks on policy 
 # EXPECTED RESULTS: Validating Underwriter can create manual UW task for all the listed tasks on policy
  
 # User : Jlowe
@regression @tc17036 @mtr2465
Feature: TC 17036 - HO6, UW, Task, Validate UW can create manual Task on a policy

  Scenario: Validate that Underwriter can create manual UW task for all the listed tasks on policy
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO6 product selection information and current date as effective date
    And User enters Producer Code
    And User enters all required information on HO6 quote screen with current date as prior policy date
    And User enters all required information on HO6 dwelling screen and enters <35.000> for CovC
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Task Tab
    And User adds 'Correspondence from Insured' Task
    And User adds 'General Reminder' Task
    And User adds 'General' Task
    And User adds 'Late Payment Received on Cancelled Policy' Task
    And User adds 'Manual Action Required' Task
    And User adds 'Pending Reapply Notification' Task
    And User adds 'Pending Renewal Apply Notification' Task
    And User navigates to Home Tab and Inbox
    And User validates 'Correspondence from Insured' Task and 'Manual Action Required' Task and 'Pending Reapply Notification' Task and 'Pending Renewal Apply Notification' Task is visible on Tasks Tab
		And User signs out
		And User login to Spin as Billing Underwriter Role
		And User navigates to Home Tab and Inbox
		And User validates 'Late Payment Received on Cancelled Policy' Task is visible on Inbox
		And User signs out
		And User login to Spin as Standard Agent
		And User navigates to Home Tab and Inbox
		And User validates 'General Reminder' Task and 'General' Task is visible on Inbox
		
		
		
		