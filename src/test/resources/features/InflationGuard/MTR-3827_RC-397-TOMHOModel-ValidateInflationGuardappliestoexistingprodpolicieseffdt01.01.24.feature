#Author:Mustafa Cemek
@RN_Policy_TOMHOInflationGuard
Feature: RC-397: 2024 Rate Changes- Inflation Guard: TO MHO- 01/01/2024

  @RN_Policy_TOMHOInflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3827: RC-397 -TO MHO Model-Validate Inflation Guard applies to existing prod policies eff dt 01/01/24
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHO and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User selects Building Territory List "<TerritoryList>"
    And User selects Attached Structures "<AttachedStructures>"
    And User enters Coverage A value "<CoverageA>"
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Burglar Alarm "<BurglarAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TOMHO review screen
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates TOMHO Coverage A increases by 10 percent
    Then User validates TOMHO Coverage B increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOMHO Coverage C increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOMHO Coverage D increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOMHO Hurricane Coverage A Deductible percentage
    Then User validates TOMHO Coverage A on Coverages List
    Then User validates TOMHO Coverage B on Coverages List
    Then User validates TOMHO Coverage C on Coverages List
    Then User validates TOMHO Coverage D on Coverages List
    Then User validates CovA TOMHO Inflation Guard is 10 percent
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates TOMHO 10 percentage in RN Declaration Package
    Then User validates TOMHO inflated values on Dec page for first RN
    Then User validates TOMHO inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Endorse Policy button
    And User clicks Dwelling chevron
    Then User validates CovA TOMHO Inflation Guard is 10 percent
    And User clicks Policy File Chevron
    And User clicks Endorsement Package link
    Then User validates TOMHO 10 percentage in EN Package

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA | HurricaneDeductible | FireAlarm    | BurglarAlarm    | SprinklerSystem                                          |
      | 01/01/2023    | 01/01/2024               | Owner Occupied | 9 to 12 Months |               2021 |             5 | No                 |     60000 | $500                | Central Fire | Central Burglar | Excludes attic, bathroom, closet and attached structures |
