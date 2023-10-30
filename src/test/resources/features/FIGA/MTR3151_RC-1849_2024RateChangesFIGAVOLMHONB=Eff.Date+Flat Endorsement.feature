#Author:Mustafa Cemek
@FIGA-VOLMHO3 @FIGA
Feature: RC-1849: 2024 Rate Changes- FIGA: VOL MHO - 1/1/2024

  @FIGA2024-VOLMHO3-1 @FIGA2024
  Scenario Outline: MTR-3151: RC-1849, 2024 Rate Changes: FL Annual FIGA Rate Changes - VOL MHO - NB = Eff. Date+ Flat Endorsement
    Given User navigates to Model
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters effective date "<EffectiveDate>"
    And User enters state
    And User clicks VOL MHO3 policy
    And User enters Producer Code
    And User clicks MHO3 Prior Carrier
    And User enters Prior Policy Expiration Date
    And User clicks Property Type as Private Property
    And User enters Primary Phone
    And User clicks No Email
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks Next Page
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Coverage A Dwelling
    And User clicks Save
    And User clicks Review button
    And User enters MHO3 Pay Plan Type
    And User answers all underwriting questions for MHO3
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL MHO3 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL MHO3 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL MHO3 rate in Review
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL MHO3 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL MHO3 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL MHO3 rate in Review

    Examples: Test Data
      | username | password  | EffectiveDate | EndorsementEffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction |
      | mcemek   | Nov@2023! | 1/1/2024      | 1/2/2024                 | Owner Occupied |             12 |               2021 |
