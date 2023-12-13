#Author: Can Yavas
##added on 08/04/2023

@regression @tc38505 @mtr474 @dp3regression
Feature: US8687 - U/I Task Inbox View - Mandatory Mediation-Arbitration Acknowledgment -
NB - UW clerk group can Suspend the task via Task Dashboard

  Scenario: User creates NB policy and change the date from 30 days and Change Arbitration as Yes then it require UW approval

    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr474>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr474>
    And User enters all required information on DP3 dwelling screen <mtr474>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that DP3 policy has been created successfully and closes unnecessary tabs
    And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date <mtr474>
		And User clicks dwelling tab and validates MMA selected as No and switches MMA as Yes
		And User finalizes transaction
		And User completes endorsement <mtr474>
		And User validates that Endorsement transaction has been completed successfully
		And User takes note of the policy number for <MTR474>
		And User signs out
		And User login to Spin as Underwriter Clerk
		And User searches previously created policy for <MTR474>
		And User clicks Task Tab
		And User validates expected messages <Mandatory Mediation-Arbitration discount applied on Policy> and notates work date
		And User changes system date to the work date
		And User clicks Policy Tab
		And User clicks Task Dashboard
		And User completes all required information on task dashboard lookup screen
		And User validates <Mandatory Mediation-Arbitration discount applied on Policy_> label is displayed on reports and clicks label
		And User validates <Mandatory Mediation-Arbitration discount applied on Policy "Policy No". Please Review and follow up for signed acknowledgment if not received.> label is visible
		And User starts suspend transaction
		And User searches previously created policy for <MTR474>
		And User clicks Task Tab
		And User validates <Mandatory Mediation-Arbitration discount applied on Policy "Policy No". Please Review and follow up for signed acknowledgment if not received.> label is visible
		And User valiates Task Tab Referring User Status displayed as Underwriting Clerk
		And User validates Task Status as open
		And User validates task date
		Then User clicks generated task edit link and validates suspend label is visible
		
		
		
		