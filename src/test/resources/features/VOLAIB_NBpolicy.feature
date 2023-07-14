#Author: Can Yavas
Feature: Issuing AIB policy
#updated on 07/14/2023 by Can Yavas

  @aib @smoke
  Scenario: Valid AIB policy creation
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters AIB product selection information and effective date
    And User enters all required information on AIB quote screen
    And User selects liability coverage on quote screen
    And User adds operator information on quote screen
    And User enters all required information on AIB boat dwelling screen
    And User enters all required information on AIB review screen
    And User creates AIB application
    And User answers all underwriting questions for AIB
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that AIB policy has been created successfully
		##user changed to admin when executing this test for ignoring mvr scoring