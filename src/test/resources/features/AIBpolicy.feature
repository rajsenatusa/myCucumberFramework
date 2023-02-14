#Author: Can Yavas
Feature: Issuing AIB policy

  @aib
  Scenario: Valid AIB policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter AIB product selection information and effective date
    And I enter all required information on AIB quote screen
    And I select liability coverage on quote screen
    And I added operator information on quote screen
    And I enter all required information on AIB boat dwelling screen
    And I enter all required information on AIB review screen
    And I create AIB application
    Then I validate the AIB policy has been created successfully
