#Author: Can Yavas


Feature: Issuing HO3 policy

  @smoke
  Scenario: Valid HO3 policy creation
    Given I signin Spin as Standard Agent
    And I start transaction as a new customer
    When I enter all required information
    Then I validate the HO3 policy has been created successfully
    


