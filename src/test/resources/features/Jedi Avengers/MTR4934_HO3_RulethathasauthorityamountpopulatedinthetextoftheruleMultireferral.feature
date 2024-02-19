# Author: Mustafa Cemek
# created on 02/15/2024
#TEST CASE NUMBER & TITLE: JA-147-MTR-4934-HO3-Rule that has authority amount populated in the text of the rule-Multi referral
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter has the ability to create Company Privileged Note. Edit or Delete buttons not displays for UW. Agent is not able to see Company Privileged Note that was created. Agent is not able to see Company Privileged Note that was created. UW Manager can Edit the note
#User: Standard Agent, Underwriter, UW Manager
@regression @mtr4934 @ja
Feature: MTR457_HO3_Verify_UW_Manager_can_Edit_the_Note
#EXPECTED RESULTS YAZZZZZZ
 Scenario: Verify_Underwriter_creates_and_UW_Manager_can_Edit_the_note
    Given User login to Spin as Standard Agent
    And User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO3 product selection information and current date as effective date
     And User enters all required information on HO3 quote screen <mtr4934>
    And User enters all required information on HO3 dwelling screen <mtr4934>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User takes note of the application number <mtr4934>
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    Then User validates the Submit for Approval messages
    And User submits the application for UW approval
    Then User validates the Application is submitted for approval
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Application Number for <mtr4934>
    Then User validates the Submitter Issues
		And User approves the application or transaction
  
    And User issues policy
    
    
    Then User validates NB HO3 policy has been created successfully and takes note of the policy number for <mtr457>
    And User signs out
    And User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr457>
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a New Note for <mtr457>
    Then User validates a New Note has been created successfully in Notes List <mtr457>
    Then User verifies that no Edit or Delete links are displayed
    And User signs out
    And User login to Spin as Standard Agent
    And User Searchs for Policy Number for <mtr457>
    And User clicks Notes Chevron
    Then User verifies that Agent cannot see Company Privileged Note
    And User signs out
    And User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr457>
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a General Note
    Then User validates a General Note has been created successfully in Notes List <mtr457>
    Then User verifies that no Edit or Delete links are displayed
    And User signs out
    And User login to Spin as Standard Agent
    And User Searchs for Policy Number for <mtr457>
    And User clicks Notes Chevron
    Then User verifies that Agent can see General Note
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User Searchs for Policy Number for <mtr457>
    And User clicks Notes Chevron
    Then User verifies that Edit or Delete links are displayed
    Then User verifies that Underwriter Manager can Edit and Save General Note
