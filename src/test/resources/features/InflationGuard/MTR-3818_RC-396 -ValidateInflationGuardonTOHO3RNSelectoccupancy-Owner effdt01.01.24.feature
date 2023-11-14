#Author:Mustafa Cemek
@RN_Policy_TOHO3InflationGuard
Feature: RC-396: 2024 Rate Changes- Inflation Guard: TO HO3- 01/01/2024

  @RN_Policy_TOHO3InflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3818: RC-396 -Validate Inflation Guard on TO HO3 RN  Select occupancy - Owner  eff dt 01/01/24
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOHO3 and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User selects Building Territory List "<TerritoryList>"
    And User selects Structure Rented to Others "<StructureRentedOthers>"
    And User clicks Save
    And User selects Quality Grade "<QualityGrade>"
    And User clicks Calculate Button
    And User clicks Save
    And User selects Hurricane Deductible "<HurricaneDeductible>"
    And User selects Sinkhole Loss
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Burglar Alarm "<BurglarAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User clicks next page button
    And User enters all required information on TOHO3 review screen
    And User creates TOHO3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects dwelling type
    And User clicks dwelling chevron and selects roof material
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates TOHO3 Coverage A increases by 10 percent
    Then User validates TOHO3 Coverage B increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOHO3 Coverage C increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOHO3 Coverage D increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TOHO3 Hurricane Coverage A Deductible percentage
    Then User validates TOHO3 Ordinance or Law Increases off of Coverage A inflated amount of 10 percent
    Then User validates TOHO3 Sinkhole Loss
    Then User validates TOHO3 Coverage A on Coverages List
    Then User validates TOHO3 Coverage B on Coverages List
    Then User validates TOHO3 Coverage C on Coverages List
    Then User validates TOHO3 Coverage D on Coverages List
    Then User validates TOHO3 Inflated value of Ordinance or Law on Coverages List
    Then User validates CovA TOHO3 Inflation Guard is 10 percent
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates TOHO3 10 percentage in RN Declaration Package
    Then User validates TOHO3 inflated values on Dec page for first RN
    Then User validates TOHO3 inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Endorse Policy button
    And User clicks Dwelling chevron
    Then User validates CovA TOHO3 Inflation Guard is 10 percent
    And User clicks Policy File Chevron
    And User clicks Endorsement Package link
    Then User validates TOHO3 10 percentage in EN Package
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates TOHO3 Coverage A increases by 10 percent after second RN
    Then User validates TOHO3 Coverage B increases off of Coverage A inflated limit amount of 10 percent after second RN
    Then User validates TOHO3 Coverage C increases off of Coverage A inflated limit amount of 10 percent after second RN
    Then User validates TOHO3 Coverage D increases off of Coverage A inflated limit amount of 10 percent after second RN
    Then User validates TOHO3 Hurricane Coverage A Deductible percentage after second RN
    Then User validates TOHO3 Ordinance or Law Increases off of Coverage A inflated amount of 10 percent after second RN
    Then User validates TOHO3 Sinkhole Loss after second RN
    Then User validates TOHO3 Coverage A on Coverages List after second RN
    Then User validates TOHO3 Coverage B on Coverages List after second RN
    Then User validates TOHO3 Coverage C on Coverages List after second RN
    Then User validates TOHO3 Coverage D on Coverages List after second RN
    Then User validates TOHO3 Inflated value of Ordinance or Law on Coverages List after second RN
    Then User validates CovA TOHO3 Inflation Guard is 10 percent after second RN
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates TOHO3 10 percentage in RN Declaration Package after second RN
    Then User validates TOHO3 inflated values on Dec page after second RN
    Then User validates TOHO3 inflated values on OIR B1 1670 form after second RN

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | TerritoryList | StructureRentedOthers | QualityGrade | HurricaneDeductible | FireAlarm       | BurglarAlarm    | SprinklerSystem                                          |
      | 01/01/2023    | 1/1/2024                 | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 |             5 | No                    | Economy      | 2%                  | Central Station | Central Station | Excludes attic, bathroom, closet and attached structures |
