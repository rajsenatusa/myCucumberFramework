@smokeRateChangeHO6
Feature: Rate Change-2023 HO6  

  Background: 
    Given User navigates to QA7
    And User enters a valid username
    And User enters a valid password
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
    And User enters Email
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

  @smokeRateChangeHO6-1
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone X and Foundation Basement
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone X and Foundation Basement
    Then User verifies HO6 Personal Property Flood Rate Zone X and Foundation Basement
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Basement            | X                 | No                  | No           | No                   |

  @smokeRateChangeHO6-2
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone D and Foundation Slab
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone D and Foundation Slab
    Then User verifies HO6 Personal Property Flood Rate Zone D and Foundation Slab
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Slab                | D                 | No                  | No           | No                   |
 
  @smokeRateChangeHO6-3
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone B and Foundation Elevated
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone B and Foundation Elevated
    Then User verifies HO6 Personal Property Flood Rate Zone B and Foundation Elevated
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Elevated            | B                 | No                  | No           | No                   |
 
	@smokeRateChangeHO6-4
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone C and Foundation Basement
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone C and Foundation Basement
    Then User verifies HO6 Personal Property Flood Rate Zone C and Foundation Basement
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Basement            | C                 | No                  | No           | No                   |
 
	@smokeRateChangeHO6-5
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone A and Foundation Slab
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone A and Foundation Slab
    Then User verifies HO6 Personal Property Flood Rate Zone A and Foundation Slab
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Slab                | A                 | No                  | No           | No                   |
 
	@smokeRateChangeHO6-6
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone AE and Foundation Basement
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone AE and Foundation Basement
    Then User verifies HO6 Personal Property Flood Rate Zone AE and Foundation Basement
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Basement            | AE                | No                  | No           | No                   |
 
	@smokeRateChangeHO6-7
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone AH and Foundation Slab
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone AH and Foundation Slab
    Then User verifies HO6 Personal Property Flood Rate Zone AH and Foundation Slab
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Slab                | AH                | No                  | No           | No                   |
 
	@smokeRateChangeHO6-8
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone AO and Foundation Basement
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone AO and Foundation Basement
    Then User verifies HO6 Personal Property Flood Rate Zone AO and Foundation Basement
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Basement            | AO                | No                  | No           | No                   |
 
	@smokeRateChangeHO6-9
  Scenario Outline: Rate Change-2023 HO6-Flood Rate Zone A99 and Foundation Basement
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
    And User enters Roof Material
    And User calculates RCE
    And User clicks Worksheets chevron
    Then User verifies HO6 Building Flood Rate Zone A99 and Foundation Basement
    Then User verifies HO6 Personal Property Flood Rate Zone A99 and Foundation Basement
    And User clicks Finalize button

    Examples: Test Data
      | FloodCoverage | FloodPersonalProperty | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Yes           | $10,000               | $500                    | Basement            | A99               | No                  | No           | No                   |

	

