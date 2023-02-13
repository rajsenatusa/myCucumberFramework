#Author: Can Yavas

Feature: Issuing DP1 policy

  @dp1
  Scenario: Valid DP1 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter DP1 product selection information and effective date
    And I enter all required information on DP1 quote screen
    And I enter all required information on DP1 dwelling screen
    And I enter all required information on DP1 review screen
    And I create DP1 application
    Then I validate the DP1 policy has been created successfully
