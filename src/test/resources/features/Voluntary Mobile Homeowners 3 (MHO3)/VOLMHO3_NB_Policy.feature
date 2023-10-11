#Author:Mustafa Cemek
@NB_Policy_VOLMHO3
Feature: New Business Policy VOL MHO3

  @NB_Policy_VOLMHO3-1 @healthcheck
  Scenario Outline: NB VOL MHO3
    Given User navigates to QA7
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
    Then User verifies NB MHO3 policy has been created successfully

    Examples: Test Data
      | username | password  | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction |
      | mcemek   | Oct@2023! | 10/27/2023    | Owner Occupied |             12 |               2021 |
