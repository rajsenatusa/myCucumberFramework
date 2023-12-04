#Author: Can Yavas
##created on 10/18/2023

# TEST CASE NUMBER & TITLE: TC 34248--US4178:FORM: Marina As Additional Insured - Regression Test Case
# PRECONDITIONS (IF ANY): Current AIB application with 1 boat stored at Marina and a driver applied
# HIGH LEVEL STEPS OF TEST SCRIPT:  Confirm that the UI has the updates the additional Interest page so the Marina endorsement can be added
# EXPECTED RESULTS:
# 1. Confirm that the UI has the updates the additional Interest page so the Marina endorsement can be added
# 2. Confirm that the policy is being populated with the required information from the Additional Insured
# 3. Confirm that the edits are displayed when an additional insured-marina is added that does not have at least
#  one boat in a marina
# 4. Confirm that clicking on Fix on the edit message will navigate the user to the Boat page
# 5. Confirm that when the policy has the endorsement, that the Form is in the Forms section of the UI
# User: AG1730, gallopadmin


@regression @tc34248 @mtr4465
Feature: TC 34248-mtr4465-US4178:FORM: Marina As Additional Insured - Regression Test Case

  Scenario: Validating that the UI has the updates the additional Interest page so the Marina endorsement can be added
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc34248>
		And User enters AIB product selection information and current date as effective date
		And User enters all required information on AIB quote screen for <tc34248>
		And User selects liability coverage on quote screen for <tc34248>
		And User adds operator information on quote screen <tc34248>
		And User enters all required information on AIB boat dwelling screen for <tc34248>
		And User enters all required information on AIB review screen
		And User creates AIB application
		And User answers all underwriting questions for AIB
		And User clicks Additional Interest Chevron <tc34248>
		And User clicks Add Additional Interest button <tc34248>
		And User completes required information on add additional interests screen and add first mortgagee <tc34248>
		And User does necessary validations with different selections and checks required messages displayed in additional interest screen
		And User clicks Forms Chevron <tc34248>
    And User validates all expected forms is visible on forms screen <tc34248>
		And User clicks AIIC SB MAI 08 21 form and validates form version
		And User checks application dwelling screen and finalizes transaction
		And User issues policy and close unnecessary tabs and taking note of the policy number <tc34248>
		And User clicks Policy File Chevron <tc34248>
		And User clicks Small Boat Application Link and validates form version
		And User clicks Small Boat Declaration Link and validates form version
		And User clicks New Business Package Link and validates form version and marina letter
		And User searches for the policy <tc34248>
		And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date plus 10 days <tc34248>
		And User clicks Vehicles Tab and adds another boat
		And User clicks Additional Interest Chevron <tc34248>
		And User clicks Add Additional Interest button and add Marina as Additional Insured <tc34248>
		And User finalizes transaction and completes endorsement <tc34248>
		And User searches for the policy <tc34248>
		And User clicks Forms Chevron <tc34248>
		And User validates AIIC SB MAI 08 21 is visible
		And User clicks Policy File Chevron <tc34248>
		And User validates 'Marina Endorsement Package' and 'Additional Insured - Marina - Batch - PO BOX 7089 Westlake Village, CA 91359-7089' labels are visible
		And User searches for the policy <tc34248>
		And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as previous endorsement date plus 10 days <tc34248>
		And User deletes one boat
		And User clicks Additional Interest Chevron <tc34248>
		And User validates 'A Boat with an Additional Interest - Marina has been removed from the policy' text is visible
		And User finalizes transaction and validates boat removed message has been displayed
		And User clicks Modify Application
		And User clicks Additional Interest Chevron <tc34248>
		And User deletes related Additional Insured Marina
		And User finalizes transaction and completes endorsement <tc34248>
		And User clicks Forms Chevron <tc34248>
		And User validates AIIC SB MAI 08 21 is visible
		And User clicks Policy File Chevron <tc34248>
		And User validates 'Marina Endorsement Package' labels is not visible anymore
		And User searches for the policy <tc34248>
		And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as previous endorsement date plus 15 days <tc34248>
		And User clicks Additional Interest Chevron <tc34248>
		And User validates 'Additional Interest - Marina does not have an active interest in one or more boats' message not visible
		And User finalizes transaction and validates marina does not have active interest message has been displayed
		Then User process endorsement and completes test <tc34248>
		
		