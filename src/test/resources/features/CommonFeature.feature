#Author: Kalesha
Feature: Test login


Scenario: MTR 355 Validate HO3 MMA AcknowledgmentFrom on NB and END
    Given I signin Spin as Standard Agent
      Given User search for "policyNumber"
      And I navigate to policyfile screen
      And I navigate to dwellings screen