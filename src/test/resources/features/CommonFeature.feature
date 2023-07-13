#Author: Kalesha
#updated on 07/12/2023 by Can Yavas
Feature: Test login

  @commonsteps
  Scenario: MTR 355 Validate HO3 MMA AcknowledgmentFrom on NB and END
  
		Given User navigates to the spin model website
		Given User enters a valid username  
		Given User enters a valid password
		Given User clicks on the signin button
		Given User quits the browser
    Given User login to Spin as Standard Agent
    Given User login to Spin as Admin Agent
    Given User starts transaction as a new customer
    Given User search for "policyNumber"
    Given User issues policy
    When User enters all required information on policy information screen
    And I navigate to policyfile screen
    And I navigate to dwelling screen
    And I start transaction on policy
    And I select endorsement transaction on "days"
    And I finalize and process the transaction
    And I finalize the application or transaction
    And I Issue new business with payment type "None"
    And I fill all the details on Review screen for "LOB" product
    And I create application for "DP3" product
    And I fill all the "DP3" product UW questions
    And I submit the application for UW approval
    And I submit the application for UW manager approval
    And I sign out
    And I renew policy "policyNum" to next term through manual transaction
    And I renew policy to next term through manual transaction
    And I reinstate  policy "policyNumber"
    And I cancel  policy "policyNumber"
    And I cancel policy through manual transaction
    And I reinstate policy through manual transaction
    And Report loss on policy with effective of "days"
    And I select only loss cause as "Loss cause"
    And I submit the claim transaction for approval
    And User search for the app or transaction or policy
    And I approve the application or transaction
