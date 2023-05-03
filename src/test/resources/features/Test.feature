#Author: Kalesha
Feature: HO3 MMA scenario

  @smokeTest @regression12
  Scenario: MTR 355 Validate HO3 MMA AcknowledgmentFrom on NB and END
    Given I signin Spin as Standard Agent
    #When I start transaction as a new customer
    #And I enter all required information on customer information screen
    #And I enter product selection information and effective date
    #And I enter all required information on quote screen
    #And I validate MMA should default to Select on dwelling screen
    #And I enter all required information on dwelling screen
    #And I enter all the information on review screen
    #And I create application of HO3
    #And I fill all the uw questions
    #And I select MMA as Yes on dwelling screen
    #And I validate MMA field defaulted to Yes on dwelling screen
    #And I finalize and issue new business
    #Then I validate the HO3 policy has been created successfully
    Given User search for "AGH0000568-01"
    And I navigate to policyfile screen
    And I click on on the application and validate the MMA acknowledge form "AIIC HO3 MMAA 03 22" attached in the application form
    #And I start transaction on policy
    #And I select endorsement transaction on "03/01/2023"
    #And I finalize and process
    #And I navigate to policyfile screen
    #Then I click on on the application and validate HO3 MMA acknowledge form not attached in the endorsement package
    
#demo
  @smokeTest1444
  Scenario: Valid Credentials
    Given I signin Spin as Underwriter

  @testregression12345
  Scenario: Valid Agent Credentials
    Given I signin Spin as Agent
    Then I validate that I am logged in

  @smokeTest
  Scenario: LoginToSpin.feature
