#Author:Mustafa Cemek
@RateChangeVOLMHO3
Feature: RC-11: 2023 Rate Changes- FL Annual Filings: VOL MHO

  @RateChangeVOLMHO3-1
  Scenario Outline: RC-1506: RC-11-Verify the Updates on 2023 Rate Changes- FL Annual Filings: VOL MHO3 - NB on the Eff date
    Given User navigates to QA5
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
    And User enters VOL MHO3 Coverage A Dwelling
    And User clicks Save
    And User clicks Review button
    And User enters MHO3 Pay Plan Type
    And User answers all underwriting questions for MHO3
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User clicks Worksheets chevron
    Then User verifies VOL MHO3 Private Property NonHurricane rate
    Then User verifies VOL MHO3 Private Property Hurricane rate

    Examples: Test Data
      | username | password  | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction |
      | mkoziel  | Aug@2023! | 7/23/2023     | Owner Occupied |             12 |               2021 |