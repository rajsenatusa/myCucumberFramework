#Author:Mustafa Cemek
@FIGA-UMB
Feature: RC-1859: 2024 Rate Changes- FIGA: UMB - 1/1/2024

  @FIGA2024-UMB-1 @FIGA2024
  Scenario Outline: MTR-3646: RC-1859 - 2024 Rate Changes - FIGA: UMB - Multi EN on NB
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for UMB and "<EffectiveDate>"
    And User enters Producer Code for <mtr3646>
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
    Then User validates 2024 FIGA UMB rate in Worksheets
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA UMB rate in Worksheets
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<SecondEndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA UMB rate in Worksheets
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<ThirdEndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA UMB rate in Worksheets

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | SecondEndorsementEffectiveDate | ThirdEndorsementEffectiveDate | LiabilityCoverage | UninsuredLimit | NumberOfAuto |
      | 01/01/2024    | 01/05/2024               | 01/10/2024                     | 01/15/2024                    |         1,000,000 |              0 |            2 |
