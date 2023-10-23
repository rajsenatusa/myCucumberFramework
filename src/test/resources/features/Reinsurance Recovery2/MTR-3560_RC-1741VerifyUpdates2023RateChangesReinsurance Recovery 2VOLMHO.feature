#Author:Mustafa Cemek
@NB_Policy_VOLMHO3Reinsurance
Feature: RC-1741: 2023 Rate Changes- FL Reinsurance Recovery 2: VOL MHO

  @NB_Policy_VOLMHO3Reinsurance-1 @ReinsuranceRecovery
  Scenario Outline: MTR-3560: RC-1741-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery 2: VOL MHO - NB on the Eff date
    Given User navigates to QA2
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
    And User enters Coverage A Dwelling as 50000
    And User clicks Save
    And User clicks Review button
    And User enters MHO3 Pay Plan Type
    And User answers all underwriting questions for MHO3
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    And User clicks NonHurricane Base Premium
    Then User validates NonHurricane VOL MHO3 base rate in Worksheets
    And User clicks Hurricane Base Premium
    Then User validates Hurricane VOL MHO3 base rate in Worksheets
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Dwelling chevron
    And User enters Coverage A Dwelling as 51000
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    And User clicks NonHurricane Base Premium
    Then User validates NonHurricane VOL MHO3 additional premium base rate in Worksheets
    And User clicks Hurricane Base Premium
    Then User validates Hurricane VOL MHO3 additional premium base rate in Worksheets

#
    Examples: Test Data
      | username | password  | EffectiveDate | EndorsementEffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction |
      | mcemek   | Oct@2023! | 10/27/2023    | 10/27/2023               | Owner Occupied |             12 |               2021 |
