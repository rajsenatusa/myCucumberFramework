#updated on 07/17/2023 by Can Yavas
##Any contributor should review these steps before starting to write code in the framework. Basically these includes all possible steps that needs to be used.

Feature: Common Transactions and Steps
  @commonsteps
  Scenario: Common Transactions and Steps which have been used in the framework
		Given User navigates to the spin website
		Given User signin Spin with username "username" and password "password"
		Given User selects the product from Product Selection List as "LOB"
		Given User enters Quote Information as effective date with "days" days difference and state "state" and "CarrierGroup" Insurance Carrier group
		Given User selects the entity as "Entity"
		Given User login to Spin as Standard Agent
		Given User login to Spin as Admin Agent
		Given User login to Spin as Underwriter
		Given User enters a valid username  
		Given User enters a valid password
		Given User clicks on the signin button
		Given User enters all required information on Insured information section
		Given User fills the address details with "address" and zip "zip"
    Given User starts transaction as a new customer
    Given User selects "package" package
    Given User search for "policyNumber"
    Given User searches policy number before starting transaction
    Given User issues policy
    When User enters all required information on policy information screen
    And User navigates to policyfile screen
    And User navigates to dwelling screen
    And User checks application dwelling screen and finalizes transaction
    And User starts transaction on policy
		And User navigates to Policy tab
		And User enters Policy General detail with Producer Code "producercode"
		And User validates the following message should display "message"
    And User selects endorsement transaction on "days"
    And User finalizes and process the transaction
    And User finalizes the application or transaction
    And User issues new business with payment type "None"
    And User enters all the information on DP3 review screen
    And User fills all the details on Review screen for "LOB" product
    And User enters Order Insurance Score
    And User creates application for "DP3" product
    And User fills all the DP3 UW questions
    And User fills all the HO3 UW questions
    And User fills all the "DP3" product UW questions
    And User submits the application for UW approval
    And User submits the application for UW manager approval
    And User signs out
    And User quits the browser
    And User renews policy "policyNum" to next term through manual transaction
    And User renews policy to next term through manual transaction
    And User reinstates  policy "policyNumber"
    And User cancels policy "policyNumber"
    And User cancels policy through manual transaction
    And User reinstates policy through manual transaction
    And User reports loss on policy with effective of "days"
    And User selects only loss cause as "Loss cause"
    And User submits the claim transaction for approval
    And User search for the app or transaction or policy
    And User approves the application or transaction
    And User changes date of system "days"
    And User enters Distance to Hydrant_Accredited Water Source
    And User enters Roof Material
    And User selects loss cause as "losscause" and other related questions
