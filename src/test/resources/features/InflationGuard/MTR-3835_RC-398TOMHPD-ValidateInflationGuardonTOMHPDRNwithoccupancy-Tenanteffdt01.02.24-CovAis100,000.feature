#Author:Mustafa Cemek
@RN_Policy_TOMHPDInflationGuard
Feature: RC-398: 2024 Rate Changes- Inflation Guard: TO MHPD- 01/01/2024

  @RN_Policy_TOMHPDInflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3835: RC-398 TO MHPD - Validate Inflation Guard on TO MHPD RN with occupancy - Tenant eff dt 01/02/24 - Cov A is 100,000
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHPD and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User enters Lease Term "<LeaseTerm>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User selects Building Territory List "<TerritoryList>"
    And User clicks CoverageA tab and enters Coverage A value "<CoverageA>"
    And User selects Hurricane Deductible as 5 percent
    And User selects Attached Structures "<AttachedStructures>"
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User clicks Seasonal Property
    And User clicks Original Systems Surcharge
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TOMHPD review screen
    And User creates TOMHPD application
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
    Then User validates TOMHPD Coverage A increases by 10 percent
    Then User validates TOMHPD Coverage B increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOMHPD Coverage C increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOMHPD Coverage D increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOMHPD Hurricane Coverage A Deductible percentage
    Then User validates TOMHPD Coverage A on Coverages List
    Then User validates TOMHPD Coverage B on Coverages List
    Then User validates TOMHPD Coverage C on Coverages List
    Then User validates TOMHPD Coverage D on Coverages List
    Then User validates CovA TOMHPD Inflation Guard is 10 percent
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates TOMHPD 10 percentage in RN Declaration Package
    Then User validates TOMHPD inflated values on Dec page for first RN
    Then User validates TOMHPD inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Endorse Policy button
    And User clicks Dwelling chevron
    Then User validates CovA TOMHPD Inflation Guard is 10 percent
    And User clicks Policy File Chevron
    And User clicks Endorsement Package link
    Then User validates TOMHPD 10 percentage in EN Package
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates CovA TOMHPD Inflation Guard is 10 percent

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | Occupancy       | MonthsOccupied | LeaseTerm | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA | FireAlarm    | SprinklerSystem                                          |
      | 01/02/2023    | 01/02/2024               | Tenant Occupied | 9 to 12 Months | Annual    |               2021 |             5 | No                 |    100000 | Fire Station | Excludes attic, bathroom, closet and attached structures |
