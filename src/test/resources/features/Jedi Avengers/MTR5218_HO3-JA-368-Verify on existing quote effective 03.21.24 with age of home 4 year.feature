# Author: Mustafa Cemek
# created on 03/19/2024
#TEST CASE NUMBER & TITLE: JA-368-MTR-5218-JA-368-Verify on existing quote effective 03/21/24 with age of home -4 year
#Precondition: Create a HO3 quote.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Builders base rate changed for Water_nW, FireLightning, Liability, Other,Weather, Theft,CGCC, Hurricane correctly when effective date change (03/21/2024)
#User: Standard Agent, Admin
@regression @mtr5218 @ja
Feature: MTR5218_HO3_Verify_base_rates_can_display_correctly after effective date change (03/21/2024)

  Scenario: Verify_Admin_Agent_can_display_Builders_base_rate_correctly
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr5207>
    And User enters HO3 product selection information and date as 03.19.2024
    And User enters Producer Code
    And User enters all required information on HO3 quote screen <mtr4934>
    And User enters all required information on HO3 dwelling screen <mtr5218>
    And User validates that HO3 quote has been created successfully <mtr5218>
    And User clicks Policy Chevron
    And User enters effective date as 03.21.2024 <mtr5218>
    And User validates warning message, 'There is a new product version for this effective date.'
    And User clicks Change Product
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
   