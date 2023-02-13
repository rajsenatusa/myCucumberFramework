#Author: Can Yavas


Feature: Issuing HO3 policy

  @ho3
  Scenario: Valid HO3 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter product selection information and effective date
    And I enter all required information on quote screen
    And I enter all required information on dwelling screen
    And I enter all required information on review screen
    And I create HO3 application
    Then I validate the HO3 policy has been created successfully
    


