#Author: Kalesha
Feature: Test login


Scenario: MTR 355 Validate HO3 MMA AcknowledgmentFrom on NB and END
    Given I signin Spin as Standard Agent
    And I select the entity as "Individual"
      Given User search for "policyNumber"
      And I navigate to policyfile screen
      And I navigate to dwelling screen
      And I start transaction on policy
      And I select endorsement transaction on "03/09/2023"
    And I finalize and process