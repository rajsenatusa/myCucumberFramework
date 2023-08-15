#Author: Can Yavas
##created on 08/15/2023

@regression @mtr451
Feature: TC38732 : US8754 - U/I CORRESPONDENCE Mandatory Mediation-Arbitration Acknowledgment 
AIIC DP1 MMAA 04 23 - DP1 - NB Joint After 07/01/2022

  Scenario: Validate policy number and property address displays correctly on second page and Acknowledgment form AIIC DP1 displays on the policy tab at NB as part of the Application package
  and Acknowledgment form AIIC DP1 attaches after the application in the package

    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
   	And User enters all required information on policy information screen
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date as prior policy date
   	And User enters all required information on DP1 dwelling screen and select MMA as yes and validates 'Premium amount includes Mandatory Mediation-Arbitration discount. Signed acknowledgement must be attached to policy in SPIN within 15 days' message
   	And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <mtr451>
    And User clicks correspondance tab
    And User selects 'Mandatory Mediation-Arbitration Acknowledgment' from dropdown
    And User validates <Producer> and <Local Printer> texts are visible on ui
    And User clicks preview correspondance button
    And User validates information in the form
    And User clicks new recipient button
    And User gets any dropdown options and validates
    And User selects recipient name
    And User clicks cancel button
    And User clicks process correspondance button and validates quote and agent information
    And User clicks Policy File Tab for <mtr451>
    And User clicks 'Mandatory Mediation-Arbitration Acknowledgment' form and validates form version of application
    
    
    
    
    