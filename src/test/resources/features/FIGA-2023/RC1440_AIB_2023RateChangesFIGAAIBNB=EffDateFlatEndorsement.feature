#Author:Mustafa Cemek
@FIGA-AIB @FIGA
Feature: RC-1093: 2023 Rate Changes- FIGA: AIB- 10/01/2023

  @FIGA-AIB-1
  Scenario Outline: RC-1440: RC-1093 - 2023 Rate Changes- FIGA: AIB- NB = Eff. Date+ Flat Endorsement
    Given User navigates to QA5
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
    Then User validates New FIGA AIB rate
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates New FIGA AIB rate after Endorsement

    Examples: Test Data
      | username | password   | EffectiveDate | EndorsementEffectiveDate |
      | JLOWE    | Aug@2023! | 10/01/2023    | 10/02/2023               |
