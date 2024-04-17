#Author: Can Yavas
##created on 08/16/2023

@regression @mtr1413 @mho3regression  @mho3APRIL
Feature: MTR1413: MHO, Agent, Change Date Transaction

  Scenario: Validate agent can do change date transaction on MHO policy
    Given User login to Spin as Standard Agent 2
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr1413>
    And User enters MHO3 product selection information and effective date as current date
		And User enters all required information on MHO3 quote screen with prior exp date as current date <mtr1413>
		And User enters all required information on MHO3 dwelling screen <mtr1413>
    And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number
    And User clicks Start Transaction
    And User selects Change Date Transaction
    And User sets new effective date as current date plus <31> days
    And User clicks Start
    And User validates 'Requested effective date change requires underwriting review' message has been displayed
    And User clicks modify application
    And User cancels transaction
    And User searches for the policy <mtr1413>
    And User clicks Start Transaction
    And User selects Change Date Transaction
    And User sets new effective date as current date plus <30> days
    And User clicks Start
    And User clicks process and close unnecessary tabs
    Then User validates Change Date text with select dates have been displayed
    