#Author:Mustafa Cemek
@FIGA-VOLDP3
Feature: FIGA VOL DP3-2023 (RC-1090: 2023 Rate Changes- FIGA: VOL DP3- 10/01/2023)

  @FIGA-VOLDP3-1
  Scenario Outline: FIGA VOL DP3-10/01/2023: NB on Effective Date
    Given User navigates to QA7
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    When User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User adds FIGA DP3 effective date "<FIGADP3EffectiveDate>"
    And User enters state
    And User clicks VOL DP3 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Insurance Score
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type
    And User enters Occupancy
    And User enters Months Occupied
    And User enters Short Term Rental
    And User enters Has Insured resided at the risk address
    And User enters Year of Construction
    And User enters Square Feet
    And User enters Building Code Effectiveness Grade
    And User enters Distance to Hydrant_Accredited Water Source
    And User enters Dwelling Type
    And User enters Number of stories
    And User enters Roof Material   
    And User enters DP3 Mandatory Mediation Arbitration
    And User calculates replacement cost
    And User enters DP3 Pay Plan Type
    And User enters DP3 Underwritting Questions
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates New FIGA DP3 rate
    

    Examples: Test Data
      | username | password | FIGADP3EffectiveDate |
      |  mkoziel | password | 10/01/2023           |

 
  @FIGA-VOLDP3-2
  Scenario Outline: FIGA VOL DP3-09/30/2023: NB before Effective Date
    Given User navigates to QA7
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    When User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User adds FIGA DP3 effective date "<FIGADP3EffectiveDate>"
    And User enters state
    And User clicks VOL DP3 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Insurance Score
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type
    And User enters Occupancy
    And User enters Months Occupied
    And User enters Short Term Rental
    And User enters Has Insured resided at the risk address
    And User enters Year of Construction
    And User enters Square Feet
    And User enters Building Code Effectiveness Grade
    And User enters Distance to Hydrant_Accredited Water Source
    And User enters Dwelling Type
    And User enters Number of stories
    And User enters Roof Material   
    And User enters DP3 Mandatory Mediation Arbitration
    And User calculates replacement cost
    And User enters DP3 Pay Plan Type
    And User enters DP3 Underwritting Questions
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates Previous FIGA DP3 rate
    

    Examples: Test Data
      | username | password | FIGADP3EffectiveDate |
      |  mkoziel | password | 09/30/2023           |


	@FIGA-VOLDP3-3
  Scenario Outline: FIGA VOL DP3-10/01/2023: RN on Effective Date
    Given User navigates to QA7
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    When User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User adds FIGA DP3 effective date "<FIGADP3EffectiveDate>"
    And User enters state
    And User clicks VOL DP3 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Insurance Score
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type
    And User enters Occupancy
    And User enters Months Occupied
    And User enters Short Term Rental
    And User enters Has Insured resided at the risk address
    And User enters Year of Construction
    And User enters Square Feet
    And User enters Building Code Effectiveness Grade
    And User enters Distance to Hydrant_Accredited Water Source
    And User enters Dwelling Type
    And User enters Number of stories
    And User enters Roof Material   
    And User enters DP3 Mandatory Mediation Arbitration
    And User calculates replacement cost
    And User enters DP3 Pay Plan Type
    And User enters DP3 Underwritting Questions
    And User clicks Next Page
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business  
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Underwriting Questions chevron
    And User enters DP3 Underwritting Questions
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates New FIGA DP3 rate
    

    Examples: Test Data
      | username | password | FIGADP3EffectiveDate |
      |  mkoziel | password | 10/01/2022           |






 
    


















      