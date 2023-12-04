#Author: Can Yavas
##created on 08/16/2023

@regression @mtr1442
Feature: TR 8630--US 9453 :VOL MHO - Modify Inflation Guard - RN effective After 9/19/2022 HVH Cov A 500k

  Scenario: Validate Coverages will increase by 25%
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters MHO3 product selection information and effective date as current date
    And User enters Producer Code
		And User enters all required information on MHO3 quote screen with prior exp date as current date
		And User enters all required information on MHO3 dwelling screen and sets coverage A as <500.000> and coverage B as <%10> and clicks WindHailExclusion
		And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr1442>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr1442>
    And User makes payment with Credit Card for <mtr1442>
    And User does auto renewal throught batch jobs
    And User clicks Dwelling Chevron for <mtr1442>
    And User validates <Inflation Guard> label is visible
    And User gets text of CovA Inflation Value
    And User compares CovA Inflation Value with expected value and validates disabled fields values
    And User clicks Policy File Chevron for <mtr1442>
    And User clicks Renewal Decleration link for <mtr1442>
    And User switches that forms and validates form version on Renewal Declaration <mtr1442>
    And User validates data on the coverage form with expected data and completes test
    
    
    
    
    