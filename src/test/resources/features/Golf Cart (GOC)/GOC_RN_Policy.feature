#Author:Mustafa Cemek
@RN_Policy_GOC
Feature: Renewal Policy GOC
 
  @RN_Policy_GOC-1
  Scenario Outline: RN GOC
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
    And User clicks GOC policy
    And User enters Producer Code
    And User selects Have you had 6 months of continuous Golf Cart Insurance Coverage
    And User selects Are all golf carts garaged in Florida at least 6 months of the year
    And User enters Primary Phone
    And User clicks No Email
    And User selects Insurance Scor
    And User enters Has Insured resided at the risk address
    And User selects Liability Coverage Type
    And User selects Bodily Injury Per Person Per Accident
    And User selects Property Damage
    And User selects Medical Payments
    And User clicks Next Page
    And User clicks Add Driver
    And User selects Marital Status
    And User selects Does the Driver currently have a driver license
    And User selects How many years of Golf Cart Experience
    And User selects Golf Cart Safety Course
    And User clicks Next Page
    And User clicks Add Golf Cart
    And User enters Golf Cart Model Year
    And User enters Golf Cart VIN Serial Number
    And User enters Golf Cart Make
    And User enters Golf Cart Model
    And User selects Golf Cart Power Type
    And User selects Maximum Speed
    And User selects Seatbelts
    And User enters Current Market Value
    And User selects Other Than Collision Deductible
    And User selects Collision Deductible
    And User selects Does golf cart have any existing damage
    And User clicks Save
    And User clicks Review button
    And User enters GOC Pay Plan Type
    And User answers all underwriting questions for GOC
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    Then User verifies RN GOC policy has been created successfully

    Examples: Test Data
      | username | password   | EffectiveDate |
      | JLOWE    | July@2023! | 08/05/2022    |
