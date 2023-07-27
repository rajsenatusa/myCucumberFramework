#Author:Mustafa Cemek
@EN_Policy_VOLUMB
Feature: Endorsement Policy VOL UMB

  @EN_Policy_VOLUMB-1
  Scenario Outline: Valid EN VOL UMB policy creation with Scenario Outline
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
    And User returns to main page
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    Then User verifies EN UMB policy has been created successfully

    Examples: Test Data
      | EffectiveDate | LiabilityCoverage | UninsuredLimit | NumberOfAuto | EndorsementEffectiveDate |
      | 07/25/2023    |         1,000,000 |              0 |            2 | 07/27/2023               |
