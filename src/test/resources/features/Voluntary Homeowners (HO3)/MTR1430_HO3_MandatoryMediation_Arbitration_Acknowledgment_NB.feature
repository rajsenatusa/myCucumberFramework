##created on 09/07/2023 by Can Yavas
## TEST CASE NUMBER & TITLE: TC 38470--Mandatory Mediation-Arbitration Acknowledgment - HO3 - NB After 04/22/2022 review task will not display on NB and will display on END
## PRECONDITIONS (IF ANY) : Issue HO3 NB policy Effective 6/21/2021
## HIGH LEVEL STEPS OF TEST SCRIPT:
## 1. Validate task added when coverage added at NB & RN transaction
## 2. Validate task wording
## 3. Task will trigger 30 days after the NB or RN effective date
## 4. Task will be sent to the underwriting clerk group
## 5. If a user uploads document as mandatory mediation-arbitration acknowledgment close task
## 6. Validate the new task routes to the u/w clerk group and the task can be worked, suspended, transferred
## EXPECTED RESULTS: Task will not be generated on RNWL on 06/22/2022  will be generated on END and referring to UW Clerk group
## User: Gallopadmin

@regression @mtr1430
Feature: TC 38470--Mandatory Mediation-Arbitration Acknowledgment - HO3 - NB After 04/22/2022 review task will not display on NB and will display on END

  Scenario: Validate that Task will not be generated on RNWL on 06/22/2022  will be generated on END and referring to UW Clerk group
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr1430>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr1430>
		And User enters all required information on HO3 dwelling screen <mtr1430>
		And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr1430>
    And User finalizes transaction for VOL HO3 <mtr1430>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr1430>
    And User changes system date to current date <mtr1430>
    And User searches for the policy number <mtr1430>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date and starts endorsement <mtr1430>
    And User clicks Dwelling Chevron <mtr1430>
    And User validates MMA defaulted to Yes
    And User clicks Attachments Tab
    And User clicks Add Attachment button
    And User select MMA Acknowledgement form from the dropdown
    And User clicks select files to upload and imports test data pdf file
    And User validates 'View' 'Edit' 'Move' 'Copy' 'Detail' 'Delete' labels are visible
    And User clicks plus sign and validates testing.pdf is visible
    And User validates links are clickable
    And User clicks Policy File Chevron <mtr1430>
    And User clicks Finalize button and Endorses Policy <mtr1430>
    And User clicks Task Tab
    And User gets task referring status, arbitration task status, arbitration task workdate and do validations
    And User clicks Policy File Chevron <mtr1430>
    And User clicks Attachments Tab
    And User validates 'Mandatory Mediation-Arbitration Acknowledgment' text is visible
    And User clicks Policy File Chevron <mtr1430>
    And User clicks 'Mandatory Mediation-Arbitration Acknowledgment' link and takes screenshot
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr1430>
    And User clicks Policy File Chevron <mtr1430>
    And User clicks Attachments Tab
    And User clicks Edit
    And User edits description task
    And User clicks delete and validates 'Mandatory Mediation-Arbitration Acknowledgment-Updated' text is not visible and completes test
    
    
    
    
    
    
    
    