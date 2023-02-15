#Author: Can Yavas


Feature: Issuing TOHO3 policy

  @toho3
  Scenario: Valid TOHO3 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter product selection information for TOHO3 and effective date
    And I enter all required information on TOHO3 quote screen
    And I enter all required information on TOHO3 dwelling screen
    And I enter all required information on TOHO3 review screen
    And I create TOHO3 application
    Then I validate the TOHO3 policy has been created successfully
    


