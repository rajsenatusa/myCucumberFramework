#Author:Mustafa Cemek
@NB_Policy_VOLAIB
Feature: New Business Policy VOL AIB

  @NB_Policy_VOLAIB-1
  Scenario Outline: NB VOL AIB
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
    Then User verifies NB AIB policy has been created successfully

    Examples: Test Data
      | username | password   | EffectiveDate |
      | JLOWE    | July@2023! | 08/05/2023    |
