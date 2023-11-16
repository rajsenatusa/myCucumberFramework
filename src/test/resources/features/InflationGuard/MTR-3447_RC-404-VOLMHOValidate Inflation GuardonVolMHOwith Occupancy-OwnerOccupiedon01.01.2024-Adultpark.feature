#Author:Mustafa Cemek
@RN_Policy_VOLMHOInflationGuard
Feature: RC-404: 2024 Rate Changes- Inflation Guard: VOL MHO- 01/01/2024

  @RN_Policy_VOLMHOInflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3447: RC-404- VOL MHO:Validate Inflation Guard on Vol MHO with Occupancy-Owner Occupied on 01/01/2024-Adult park
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
    And User clicks Property Type as Park
    And User clicks search for Park Name an Adult Park
    And User enters Primary Phone
    And User clicks No Email
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks Next Page
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Coverage A Dwelling
    And User selects Other Structures
    And User clicks Review button
    And User enters MHO3 Pay Plan Type
    And User answers all underwriting questions for MHO3
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates MHO3 Coverage A increases by 10 percentage
    Then User validates MHO3 Coverage B increases off of Coverage A percentage
    Then User validates MHO3 Coverage C increases off of Coverage A inflated limit amount of 10 percente
    Then User validates MHO3 Coverage D increases off of Coverage A inflated limit amount of 10 percente
    Then User validates MHO3 Coverage A on Coverages List
    Then User validates MHO3 Coverage B on Coverages List
    Then User validates MHO3 Coverage C on Coverages List
    Then User validates MHO3 Coverage D on Coverages List
    Then User validates MHO3 Coverage A is 10 percente under Inflation Guard
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates VOL MHO3 10 percentage in RN Declaration Package
    Then User validates VOL MHO3 inflated values on Dec page for first RN
    Then User validates VOL MHO3 inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Dwelling chevron
    And User clicks Endorse Policy button
    
    
    And User returns to main page
    And User clicks Dwelling chevron
    Then User validates MHO3 Coverage A is 10 percente under Inflation Guard
    
    And User returns to main page
    
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates MHO3 Coverage A increases by 10 percentage after second RN
    Then User validates MHO3 Coverage B increases off of Coverage A percentage after second RN
    Then User validates MHO3 Coverage C increases off of Coverage A inflated limit amount of 10 percente after second RN
    Then User validates MHO3 Coverage D increases off of Coverage A inflated limit amount of 10 percente after second RN
    Then User validates MHO3 Coverage A on Coverages List after second RN
    Then User validates MHO3 Coverage B on Coverages List after second RN
    Then User validates MHO3 Coverage C on Coverages List after second RN
    Then User validates MHO3 Coverage D on Coverages List after second RN
    Then User validates MHO3 Coverage A is 10 percente under Inflation Guard
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates VOL MHO3 10 percentage in RN Declaration Package for second RN
    Then User validates VOL MHO3 inflated values on Dec page for second RN
    Then User validates VOL MHO3 inflated values on OIR B1 1670 form for second RN

    Examples: Test Data
      | username | password  | EffectiveDate | EndorsementEffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction |
      | mcemek   | Nov@2023! | 01/01/2023    | 01/01/2024               | Owner Occupied |             12 |               2021 |
