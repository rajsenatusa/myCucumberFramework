# Author: Mustafa Cemek
# created on 03/18/2024
#TEST CASE NUMBER & TITLE: JA-368-MTR-5207-JA-368-Verify FL HO3 with a New Construction home aged 4 years at NB is rated with the Builders Base Rates & County factor on effective date 03/20/24.
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Builders base rate should be displayed for Water_nW, FireLightning, Liability, Other,Weather, Theft,CGCC, Hurricane correctly. County factor should be displayed correctly
#User: Standard Agent, Admin
@regression @mtr5207 @ja3 @ja
Feature: MTR5207_HO3_Verify_base_rates_can_display_correctly

  Scenario: Verify_Admin_Agent_can_display_Builders_base_rate_correctly
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr5207>
    And User enters HO3 product selection information and date as 03.20.2024
    And User enters Producer Code
    And User enters all required information on HO3 quote screen <mtr4934>
    And User enters all required information on HO3 dwelling screen <mtr5207>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5207>
    And User clicks Worksheets chevron
    Then User validates Water Non-Weather Builders base rate in Worksheets
    Then User validates Fire or Lightning Builders base rate in Worksheets
    Then User validates Liability Builders base rate in Worksheets
    Then User validates Other Builders base rate in Worksheets
    Then User validates Weather Builders base rate in Worksheets
    Then User validates Theft Builders base rate in Worksheets
    Then User validates CGCC Builders base rate in Worksheets
    Then User validates Hurricane Builders base rate in Worksheets
    Then User validates County factor in Worksheets
    And User clicks Policy File Chevron <mtr5207>
    And User clicks New Business Package link <mtr5207>
    And User validates AIIC FL HO3 ACB 02 22 ACB form displays
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date <mtr4934>
    And User clicks Dwelling chevron
    And User enters Coverage A Dwelling as 550000
    And User clicks Finalize button
    And User clicks Endorse Policy button
    Then User verifies EN HO3 policy has been created successfully <mtr4934>
    And User clicks Worksheets chevron
    Then User validates Water Non-Weather Builders base rate in Worksheets
    Then User validates Fire or Lightning Builders base rate in Worksheets
    Then User validates Liability Builders base rate in Worksheets
    Then User validates Other Builders base rate in Worksheets
    Then User validates Weather Builders base rate in Worksheets
    Then User validates Theft Builders base rate in Worksheets
    Then User validates CGCC Builders base rate in Worksheets
    Then User validates Hurricane Builders base rate in Worksheets
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    Then User verifies RN HO3 policy has been created successfully
    And User clicks Worksheets chevron
    Then User validates Water Non-Weather Builders base rate in Worksheets
    Then User validates Fire or Lightning Builders base rate in Worksheets
    Then User validates Liability Builders base rate in Worksheets
    Then User validates Other Builders base rate in Worksheets
    Then User validates Weather Builders base rate in Worksheets
    Then User validates Theft Builders base rate in Worksheets
    Then User validates CGCC Builders base rate in Worksheets
    Then User validates Hurricane Builders base rate in Worksheets
    Then User validates County factor in Worksheets
    And User clicks Policy File Chevron <mtr5207>
    #And User clicks Renewal Decleration link <mtr5207>
    #And User validates AIIC FL HO3 ACB 02 22 ACB form displays 
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    Then User verifies RN HO3 policy has been created successfully
    And User clicks Worksheets chevron
    Then User validates Water Non-Weather Builders base rate in Worksheets
    Then User validates Fire or Lightning Builders base rate in Worksheets
    Then User validates Liability Builders base rate in Worksheets
    Then User validates Other Builders base rate in Worksheets
    Then User validates Weather Builders base rate in Worksheets
    Then User validates Theft Builders base rate in Worksheets
    Then User validates CGCC Builders base rate in Worksheets
    Then User validates Hurricane Builders base rate in Worksheets
    
   
