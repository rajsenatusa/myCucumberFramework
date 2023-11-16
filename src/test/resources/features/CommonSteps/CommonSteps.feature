#updated on 07/17/2023 by Can Yavas
##Any contributor should review these steps before starting to write code in the framework. Basically these includes all possible steps that needs to be used.
Feature: Common Transactions and Steps

  @commonsteps
  Scenario: Common Transactions and Steps which have been used in the framework
    Given User navigates to the spin website
    Given User signin Spin with username "username" and password "password"
    Given User selects the product from Product Selection List as "LOB"
    Given User enters Quote Information as effective date with "days" days difference and state "state" and "CarrierGroup" Insurance Carrier group
    Given User selects the entity as "Entity"
    Given User login to Spin as Standard Agent
    Given User login to Spin as Admin Agent
    Given User login to Spin as Underwriter
    Given User enters a valid username
    Given User enters a valid password
    Given User clicks on the signin button
    Given User enters all required information on Insured information section
    Given User fills the address details with "address" and zip "zip"
    Given User starts transaction as a new customer
    Given User selects "package" package
    Given User search for "policyNumber"
    Given User searches policy number before starting transaction
    Given User issues policy
    When User enters all required information on policy information screen
    And User navigates to policyfile screen
    And User navigates to dwelling screen
    And User checks application dwelling screen and finalizes transaction
    And User starts transaction on policy
    And User navigates to Policy tab
    And User enters Policy General detail with Producer Code "producercode"
    And User validates the following message should display "message"
    And User selects endorsement transaction on "days"
    And User finalizes and process the transaction
    And User finalizes the application or transaction
    And User issues new business with payment type "None"
    And User enters all the information on DP3 review screen
    And User fills all the details on Review screen for "LOB" product
    And User enters Order Insurance Score
    And User creates application for "DP3" product
    And User fills all the DP3 UW questions
    And User fills all the HO3 UW questions
    And User fills all the "DP3" product UW questions
    And User submits the application for UW approval
    And User submits the application for UW manager approval
    And User signs out
    And User quits the browser
    And User renews policy "policyNum" to next term through manual transaction
    And User renews policy to next term through manual transaction
    And User reinstates  policy "policyNumber"
    And User cancels policy "policyNumber"
    And User cancels policy through manual transaction
    And User reinstates policy through manual transaction
    And User selects only loss cause as "Loss cause"
    And User submits the claim transaction for approval
    And User search for the app or transaction or policy
    And User approves the application or transaction
    And User changes date of system "days"
    And User enters Distance to Hydrant_Accredited Water Source
    And User enters Roof Material
    And User selects loss cause as "losscause" and other related questions
    And User finalizes transaction and issues takeout policy
    And User clicks Calculate Button
    #And User selects Number of Units {string}
    And User clicks Next on Policy Chevron
    And User clicks Review Chevron
    And User clicks Worksheets chevron
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User enters Has Insured resided at the risk address
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User enters Building Code Effectiveness Grade "<BuildingCodeEffectivenessGrade>"
    And User enters Number of stories "<NumberOfStories>"
    And User enters Roof Material "<RoofMaterial>"
    And User enters Fireplace "<Fireplace>"
    And User enters Exterior Walls "<ExteriorWalls>"
    And User clicks Reserve Package
    And User enters Coverage A Dwelling
    And User enters Animal Liability "<AnimalLiability>"
    And User enters Mandatory Mediation Arbitration
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User enters Burglar Alarm "<BurglarAlarm>"
    And User enters Secured Community and Bldg "<SecuredCommunityBldg>"
    And User enters Military Discount "<MilitaryDiscount>"
    And User enters Roof Shape "<RoofShape>"
    And User enters SWR "<SWR>"
    And User clicks Flood Coverage "<FloodCoverage>"
    And User selects Flood Coverage Deductible "<FloodCoverageDeductible>"
    And User selects Flood Personal Property "<FloodPersonalProperty>"
    And User selects Elevation Documentation "<ElevationDocumentation>"
    And User selects Flood Foundation Type "<FloodFoundationType>"
    And User selects Flood Zone Override "<FloodZoneOverride>"
    And User selects Preferred Risk Status "<PreferredRiskStatus>"
    And User selects SFHA Override "<SFHAOverride>"
    And User selects Elevated Risk Discount "<ElevatedRiskDiscount>"
    And User calculates replacement cost
    And User clicks Home
    And User clicks Inbox
    And User hovers over Admin
    And User clicks Changes Date
    And User clicks Ctrl+F
    And User clicks Windstorm or Hail Exclusion
    And User clicks Worksheets chevron
    And User clicks Entity Type
    And User selects HO3 Pay Plan Type
    And User clicks Endorse button
    And User clicks Endorse Policy button
    And User clicks Review Chevron
    And User clicks Premium Info Chevron
    And User clicks Start button
    And User clicks Finalize button
    And User returns to main page
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Windstorm or Hail Exclusion box
    And User selects Sinkhole Loss
    And User clicks History Chevron
    And User clicks Dwelling chevron
    And User clicks Integrity Select in Dwelling Detail
    And User selects Hurricane Deductible as 10 percent
    And User selects Hurricane Deductible as 5 percent
    And User clicks Renewal Decleration link
    And User clicks Endorsement Package link
    And User enters Personal Property limit
    And User selects Personal Liability limit
    And User enters Lease Term "<LeaseTerm>"    
    And User clicks Seasonal Property
    And User clicks Original Systems Surcharge	
    