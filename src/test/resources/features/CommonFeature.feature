#Author: Kalesha
Feature: Test login

@commonsteps
Scenario: MTR 355 Validate HO3 MMA AcknowledgmentFrom on NB and END
    Given I signin Spin as Standard Agent
      Given User search for "policyNumber"
      And I navigate to policyfile screen
      And I navigate to dwellings screen
      And I start transaction on policy
      And I select endorsement transaction on "03/09/2023"
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
    
    
    
    

		#I reinstate policy  - as per global variable variable policy
		#I cancel policy  - as per global variable variable policy