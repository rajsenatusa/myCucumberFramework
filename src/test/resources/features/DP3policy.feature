#Author: Can Yavas

Feature: Issuing DP3 policy

  @dp3
  Scenario: Valid DP3 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter DP3 product selection information and effective date
    And I enter all required information on DP3 quote screen
    And I enter all required information on DP3 dwelling screen
    And I enter all required information on DP3 review screen
    And I create DP3 application
    Then I validate the DP3 policy has been created successfully
