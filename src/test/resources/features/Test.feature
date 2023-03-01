#Author: Kalesha
Feature: Test login

  @smokeTest @regression12
  Scenario: MTR 355 Validate HO3 MMA AcknowledgmentFrom on NB and END
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter product selection information and effective date
    And I enter all required information on quote screen
    And I validate MMA should default to Select on dwelling screen
    And I enter all required information on dwelling screen
    And I enter all the information on review screen
    And I create application of HO3
    And I fill all the uw questions
    And I select MMA as Yes on dwelling screen
    And I validate MMA field defaulted to Yes on dwelling screen
    And I finalize and issue new business
    Then I validate the HO3 policy has been created successfully
    #Given User search for "AGH0000837-01"
    And I navigate to policyfile screen
    And I click on on the application and validate the MMA acknowledge form "AIIC HO3 MMAA 03 22" attached in the application form
    #And I start transaction on policy
    #And I select endorsement transaction on "02/28/2023"
    #And I finalize and process
    #And I navigate to policyfile screen
    #Then I click on on the application and validate HO3 MMA acknowledge form not attached in the endorsement package

  @smokeTest
  Scenario: Valid HO3 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter product selection information and effective date
    And I enter all required information on quote screen
    And I enter all required information and Roof as greater than 16 years on dwelling screen
    Then Roof error message should display
    And I enter all required information on review screen
    Given I signin Spin as Underwriter
    And I will take the ownership of Quote
    And I create HO3 application
    Then I validate the HO3 policy has been created successfully

  @smokeTest
  Scenario: Valid Credentials
    Given I signin Spin as Underwriter

  @regression
  Scenario: Valid Agent Credentials
    Given I signin Spin as Agent
    Then I validate that I am logged in

  @smokeTest
  Scenario: LoginToSpin.feature
