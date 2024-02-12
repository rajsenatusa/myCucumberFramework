#Author:Mustafa Cemek
@FIGA-VOLDP3
Feature: RC-1827: 2024 Rate Changes- FIGA: VOL DP3 - 1/1/2024

  @FIGA2024-VOLDP3-1 @FIGA2024 @regressionFEB
  Scenario Outline: MTR-3059: RC-1827, 2024 Rate Changes - FIGA: VOL DP3 - NB = Eff. Date + Flat Endorsement
    Given User navigates to Model
    And User login to Spin as Admin Agent
    When User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User adds FIGA DP3 effective date "<FIGADP3EffectiveDate>"
    And User enters state
    And User clicks VOL DP3 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Insurance Score
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type
    And User enters Occupancy
    And User enters Months Occupied
    And User enters Short Term Rental
    And User enters Has Insured resided at the risk address
    And User enters Year of Construction
    And User enters Square Feet
    And User enters Building Code Effectiveness Grade
    And User enters Distance to Hydrant_Accredited Water Source
    And User enters Dwelling Type
    And User enters Number of stories
    And User enters Roof Material
    And User enters DP3 Mandatory Mediation Arbitration
    And User calculates replacement cost
    And User enters DP3 Pay Plan Type
    And User enters DP3 Underwritting Questions
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL DP3 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL DP3 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL DP3 rate in Review
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL DP3 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL DP3 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL DP3 rate in Review

    Examples: Test Data
      | FIGADP3EffectiveDate | EndorsementEffectiveDate |
      | 01/01/2024           | 01/02/2024               |
