#Author: Can Yavas
##created on 08/16/2023

##updated due to rule change on 10/06/2023 by C.Yavas. "Select" selection removed from MMA Dropdown
##(TH-444 HO3, DP3, DP1 - default YES to Mandatory Mediation Arbitration in SPIN and API's)

@regression @tc38452 @mtr362
Feature: TC36905: U/I Mandatory Mediation-Arbitration Coverage discount on NB 07/01/2022 and require UW Approval when adding on END with 30 days
  Precondition-Issue NB effective 07/01/2022,MMA =No

  Scenario: Agent cannot add the Mandatory Mediation-Arbitration Coverage after 31 days(mid term endorsement) and agent can add after 30 days

    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen with current date as prior policy date
		And User enters all required information on DP1 dwelling screen and validates MMA dropdown includes Yes and No selections
		And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy for <tc38452>
    And User clicks Start Transaction
    And User selects Endorsement
    And User selects endorsement date as current date plus <31> days
    And User clicks finalize transaction
    And User clicks modify application
    And User cancels transaction
    And User searches for the policy <tc38452>
    And User clicks Start Transaction
    And User selects Endorsement
    And User selects endorsement date as current date plus <30> days
    And User clicks Dwelling Chevron for <tc38452>
    And User changes MMA as Yes
    And User clicks finalize transaction
    And User validates 'Mediation Arbitration Change requires Underwriting Approval' message has been displayed
    And User takes note of the application number for <tc38452>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for application number for <tc38452>
    And User clicks approve button
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for application number for <tc38452>
    And User endorses policy and completes test case
    
    