#Author: Can Yavas


Feature: Issuing UMB policy

  @umb
  Scenario: Valid UMB policy creation
    Given I signin Spin as Admin Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter UMB product selection information and effective date
    And I enter all required information on UMB quote screen
    And I enter all required information on UMB personal liability screen
    And I enter all required information on UMB review screen
    And I create UMB application
    Then I validate the UMB policy has been created successfully
