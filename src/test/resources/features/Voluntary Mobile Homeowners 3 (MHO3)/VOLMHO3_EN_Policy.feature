#Author:Mustafa Cemek
@EN_Policy_VOLMHO3
Feature: Endorsement Policy VOL MHO3

  @EN_Policy_VOLMHO3-1
  Scenario Outline: EN VOL MHO3
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
    And User returns to main page
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Endorse Policy button
    Then User verifies EN MHO3 policy has been created successfully

    Examples: Test Data
      | username | password | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | EndorsementEffectiveDate |
      | mkoziel  | password | 08/05/2023    | Owner Occupied |             12 |               2021 | 08/07/2023               |
