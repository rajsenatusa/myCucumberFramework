#Author:Mustafa Cemek
@RateChangeHO6
Feature: RC-5: 2023 Rate Changes- FL Annual Filings: VOL HO6

  @RateChangeHO6-11111 @gu
  Scenario Outline: RC-257: 2023 Rate Changes- FL Annual Filings: VOL HO6 - NB = NB. Eff. Date (04/21/2023) with Flood Coverage
    Given User navigates to Model
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    When User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters HO6 New Product Version effective date
    And User enters state
    And User clicks VOL HO6 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Insurance Score
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type
    And User enters Occupancy
    And User enters Months Occupied
    And User enters Has Insured resided at the risk address
    And User enters Year of Construction
    And User enters Square Feet
    And User enters Building Code Effectiveness Grade
    And User enters Distance to Hydrant_Accredited Water Source
    And User enters Number of stories
    And User enters Floor number of unit location
    And User enters C Personal Property
    And User clicks Flood Coverage "<FloodCoverage>"
    And User clicks Flood Flood Personal Property "<FloodPersonalProperty>"
    And User selects Flood Coverage Deductible "<FloodCoverageDeductible>"
    And User selects Flood Foundation Type "<FloodFoundationType>"
    And User selects Flood Zone Override "<FloodZoneOverride>"
    And User selects Preferred Risk Status "<PreferredRiskStatus>"
    And User selects SFHA Override "<SFHAOverride>"
    And User selects Elevated Risk Discount "<ElevatedRiskDiscount>"
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User enters HO6 Underwritting Questions
    And User enters Roof Material "<RoofMaterial>"
    And User calculates replacement cost
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone X and Foundation Basement
    Then User verifies HO6 Personal Property Flood Rate Zone X and Foundation Basement
    And User clicks Finalize button

    Examples: Test Data
      | username | password  | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount | RoofMaterial                      |
      | mcemek   | Jan@2024! | Yes           | $10,000               | $500                    | Basement            | B                 | No                  | No           | No                   | Architectural Composition Shingle |

  