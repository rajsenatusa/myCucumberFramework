#Author: Can Yavas
##created on 08/07/2023

@regression @mtr363 @dp3regression @dp3regressionFEB
Feature: MTR363--Admin, NB, END, RNWL Validate Checklist form displays Personal Property Coverage as
  ACV For Integrity Select on NB when Cov-C larger than 0 and Personal Property Replacement cost is unchecked and NA on RNWL

  Scenario: Validate that the OIR-B1-1670 form shows Actual Cash Value for Loss Settlement Basis for Coverage C when the risk has
    Coverage C larger than 0 and Personal Property Replacement Cost is unchecked on NB

    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr363>
    And User enters DP3 product selection information and effective date as current date
    And User enters Producer Code <mtr363>
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr363>
    And User enters all required information on DP3 dwelling screen and selects integrity select package
    And User validates Coverage C defaults to %25 on integrity select package
    And User validates Personal Property Replacement Cost checkbox has been enabled and not selected
    And User enters all required information on DP3 review screen
		And User creates DP3 application
    And User answers all underwriting questions for DP3 
    And User checks dwelling chevron and validates Personal Property Replacement Cost checkbox has been enabled and not selected
    And User takes note of the Coverage C
    And User finalizes transaction for <MTR363>
    And User issues policy
    And User validates that DP3 policy has been created successfully and closes unnecessary tabs
    And User clicks Policy File Chevron
    And User clicks New Business Package link
    And User switches that forms and validates <OIR-B1-1670> has been attached and shows Actual Cash Value for Loss Settlement Basis for Coverage C
    And User navigates Policy chevron and starts endorsement transaction plus <10> days current date
    And User clicks Dwelling Chevron
    And User changes package as Basic Package and validates Personal Property Replacement Cost checkbox has been enabled and not selected
    And User takes note of the policy number for <MTR363>
    And User finalizes transaction and completes endorsement
		And User validates that Endorsement transaction has been completed successfully
    Then User signs out
    And User login to Spin as Admin Agent
    And User searches for Policy Number for <MTR363>
    And User clicks Make Payment and selects credit card and enters due amount
    And User makes payment with Credit Card
    And User does Auto Renewal for the policy with batch jobs
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    And User switches that forms and validates <OIR-B1-1670> has been attached and shows Actual Cash Value for Loss Settlement Basis for Coverage C on renewal package
    
