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
    Given User login to Spin as SC Standard Agent
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
    Then User validates the Application is submitted for approval
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
    #And User clicks Next on PolPolicyicy Chevron
    And User clicks Review Chevron
    And User clicks Worksheets chevron
    And User clicks Billing Chevron
    And User clicks Additional Interests chevron
    And User clicks Add Additional Interest button
    And User enters Additional Interest Detail
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
    And User checks Modify Application button
    And User clicks Endorse Policy button
    And User clicks Review Chevron
    And User clicks Underwriting Chevron
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
    And User clicks Endorsement Package link
    And User enters Personal Property limit
    And User selects Personal Liability limit
    And User enters Lease Term "<LeaseTerm>"
    And User clicks Seasonal Property
    And User clicks Original Systems Surcharge
    And User creates MHO3 application
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User clicks Non-Renewal Transaction Selection
    And User clicks Non-Renewal Rescind Transaction Selection
    And User selects 'Failure to comply with underwriting requirements' as reason
    And User searches for Policy Number for <tc16890>
    And User changes date transaction to exp.date minus <125> days for <tc16890>
    And User enters HO3 Dwelling Address "<DwellingAddress>"
    And User enters HO3 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters Dwelling Address
    And User enters HO4 product selection information and effective date as current date
    And User enters HO4 product selection information and effective date as 04.21.2023
    And User validates that HO4 policy has been created successfully and takes note of the policy number <mtr916>
    And User clicks Policy File Chevron for <mtr916>
    And User clicks HO4 Decleration link
    And User clicks RN Transaction Selection
    And User clicks Non-Renewal Transaction Selection
    And User clicks Process
    #And User Searchs for Quote Number
    And User clicks Policy File Chevron
    And User Searchs for Policy Number for <mtr584>
    And User enters current date
    And User validates SC HO3 policy has been created successfully and takes note of the policy number for <mtr584>
    And User Searchs for Policy Number
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a New Note
    And User validates a New Note has been created successfully in Notes List
    And User enters Occupancy
    And User enters Months Occupied
    And User enters Months Occupied for MHO3
    And User enters Year of Construction
    And User login to Spin as Standard Agent
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User enters Customer Informations
    And User enters state
    And User clicks VOL DP1 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type
    And User enters Square Feet
    And User enters Building Code Effectiveness Grade
    And User enters Number of stories
    And User enters Fire Alarm
    And User enters Sprinkler System
    And User enters Roof Shape
    And User enters SWR
    And User clicks Flood Coverage as Yes and enters required fields
    And User clicks Flood Coverage
    And User clicks Flood Coverage
    And User selects Flood Coverage Deductible
    And User selects Flood Foundation Type
    And User selects Flood Zone Override
    And User selects Preferred Risk Status
    And User selects SFHA Override
    And User selects Elevated Risk Discount
    And User enters DP1 Occupancy
    And User enters HO3 product selection information and current date as effective date
    And User verifies that no Edit or Delete links are displayed
    Then User verifies that Agent cannot see Company Privileged Note
    And User login to Spin as Underwriter Clerk
    And User creates a General Note
    And User creates an Inspection Note
    Then User verifies that Agent can see General Note
    And User enters product selection information for TOMHO and current date
    Then User validates Inspection and General Notes have been created successfully in Notes List
    And User verifies that Edit or Delete links are displayed
    Then User verifies that Underwriter Manager can Edit and Save General Note
    Then User verifies that Edit or Delete links are displayed
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr219>
    And User selects Property Sold as reason <mtr154>
    And User sets the effective date as after 2 months from the current date
    And User clicks Process <mtr219>
    Then User validates that TOMHPD policy has been canceled successfully
    And User selects Cancellation
    And User selects Cancellation Notice
    And User selects Cancellation Type as Company
    And User sets the effective date as after 30 days from the current date and validates messages <mtr154>
    And User sets the effective date as before 1 day from the current date and validates error message <mtr154>
    And User takes note of the application number <mtr4934>
    And User clicks View Workflow Comments
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr154>
    And User selects Property Sold as reason <mtr154>
    And User sets the effective date as before 1 day from the current date and validates error message <mtr154>
    And User clicks Start Transaction
    And User clicks Start Transaction <mtr219>
    And User clicks View Notes
    Then User validates View Notes
    And User enters HO3 product selection information and current date as effective date
    And User enters product selection information for TOHO3 and sets effective date as current date
    And User enters DP3 product selection information and current date as effective date
    And User changes Months Occupied as 0 to 3 Months
    And User changes Coverage C Personal Property as 200000
    And User takes note of the policy number
    And User clicks More button then Take Ownership
    And User selects Reinstatement
    And User clicks New Business Package link
    And User clicks Renewal Decleration link
    And User enters Coverage A Dwelling as 550000
    And User validates that HO3 quote has been created successfully <mtr5218>
    And User enters effective date as 03.21.2024
    And User clicks Policy Chevron
    And User clicks Change Pay Plan
    Then User validates messages in Issues
    And User changes system date to current date <mtr522>
    And User changes system date to current date minus 1 day <mtr551>
    And User gets next action date and changes system date as next 3 days <mtr522>
    And User selects endorsement date as system date plus 3 days
    And User selects endorsement date as system date plus 30 days
    And User selects Pay Plan Type as Automated Credit Card
    And User changes Pay Plan to <8 Payment Plan> <mtr522>
    And User clicks Endore button
    And User clicks Finalize button
     And User clicks Save button
    And User clicks Endore Policy button
    And User changes system date to current date
    And User selects Rewrite-New
     And User selects Rewrite-Renewal
    And User clicks Home Cyber Protection
    And User clicks Forms chevron
    And User clicks Tasks chevron
    And User issues policy and makes payment with credit card
    And User validates 'Approve' is not visible on closeout screen
    And User validates 'Submit for Approval' is visible on closeout screen
    And User clicks Override Link on Underwriter Role <mtr592>
     And User override Underwriters 'Allow to Approve Age of Plumbing' as yes
     And User validates 'Issue New Business' is visible on closeout screen
    And User validates 'Approve' is visible on closeout screen
    And User validates 'Submit For Approval' is not visible on closeout screen
    And User checks Modify Application button
    And User enters a new DOB in Insured Information
    And User checks Modify Application button
    And User enters a new DOB in Insured Information
   Then User validates 'Structures Rented to Others Requires Underwriting Approval' is not visible on closeout screen
   And User clicks Structures Rented to Others link
    And User selects Limited Fungi, Mold, Wet or Dry Rot, or Bacteria
    Then User verifies four triggered referrals
     And User clicks plus sign View Notes