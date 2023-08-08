#Author:Mustafa Cemek
@FIGA-UMB @FIGA
Feature: RC-1097: 2023 Rate Changes- FIGA: UMB- 10/01/2023

  @FIGA-UMB-1
  Scenario Outline: RC-1400: RC-1097 -2023 Rate Changes- FIGA: UMB- NB = Eff. Date+ Multi Endorsement
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for UMB and "<EffectiveDate>"
    And User enters Producer Code
    And User answers previous policy written with AIIG questions
    And User enters Primary Phone
    And User clicks No Email
    And User clicks Next on Policy Chevron
    And User selects Umbrella Liability Coverage "<LiabilityCoverage>"
    And User selects Uninsured Limit "<UninsuredLimit>"
    And User enters Number of Auto "<NumberOfAuto>"
    And User clicks Save
    And User clicks Review Chevron
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User clicks Worksheets chevron
    Then User validates New FIGA UMB rate
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates New FIGA UMB rate after Endorsement
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<SecondEndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates New FIGA UMB rate after Endorsement
    

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | SecondEndorsementEffectiveDate | LiabilityCoverage | UninsuredLimit | NumberOfAuto |  
      | 10/01/2023    | 10/02/2023               | 10/03/2023                     |         1,000,000 |              0 |            2 | 
