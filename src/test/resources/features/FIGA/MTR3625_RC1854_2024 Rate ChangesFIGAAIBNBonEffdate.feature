#Author:Mustafa Cemek
@FIGA-AIB
Feature: RC-1854: 2024 Rate Changes- FIGA: AIB - 1/1/2024

  @FIGA2024-AIB-1 @FIGA2024
  Scenario Outline: MTR-3625: RC-1854, 2024 Rate Changes - FIGA: AIB - NB on the Eff date
    Given User navigates to Model
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
    And User clicks VOL AIB policy
    And User enters Producer Code
    And User clicks AIB Prior Carrier
    And User enters Prior Policy Expiration Date
    And User selects Have you had 6 months of continuous boat insurance
    And User selects Are all boats stored in Florida at least 6 months of the year
    And User enters Primary Phone
    And User clicks No Email
    And User enters Has Insured resided at the risk address
    And User selects liability coverage on quote screen
    And User adds operator information on quote screen
    And User enters all required information on AIB boat dwelling screen
    And User enters all required information on AIB review screen
    And User creates AIB application
    And User answers all underwriting questions for AIB
    And User checks application dwelling screen and finalizes transaction
    And User selects Payment Type
    And User clicks Issue New Business
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA AIB rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA AIB rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA AIB rate in Review
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA AIB rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA AIB rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA AIB rate in Review

    Examples: Test Data
      | username | password  | EffectiveDate | EndorsementEffectiveDate |
      | mcemek   | Nov@2023! | 01/01/2024    | 10/02/2024               |
