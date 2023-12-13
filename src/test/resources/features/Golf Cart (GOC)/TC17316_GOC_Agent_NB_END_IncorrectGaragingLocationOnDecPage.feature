#Author: Can Yavas
##created on 08/22/2023

## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent create NB Gold Endorsement Golf Cart policy  where the garaging location
## different than the  Lookup Address. Validate the Garaging location matches what was entered on Golf Cart Detail 
## EXPECTED RESULTS: The Garaging address on the Application and Declarations pages displays correctly 

@regression @tc17316 @mtr372 @gocregression
Feature: TC 17316-mtr372-GOC, Agent, NB, END, Incorrect Garaging Location showing on declarations page

  Scenario: Validate the Garaging address on the Application and Declarations pages displays correctly 
  
    Given User login to Spin as Admin Agent
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AG1730
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Override Link on Policy Agent Standard
    And User switches as yes for the attribute of 'Golf Cart - Allowed To Add Gold Endorsement'
    And User clicks save
		And User signs out
		When User login to Spin as Standard Agent
		And User starts transaction as a new customer
		And User enters all required information on policy information screen <tc17316>
    And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen
    And User enters all required information on GOC golfcart screen for <tc17316>
    And User enters driver information on driver screen <tc17316>
    And User enters vehicles information on vehicles screen <tc17316>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that GOC policy has been created successfully and takes note of the policy number
    And User clicks Policy File Chevron <tc17316>
    And User clicks New Business Package link and validates form versions in NB Package
    And User validates form information in declaration page and golf gold endorsement page
    And User clicks Application Link and validates form versions in Application Package
    And User searches for the policy number <tc17316>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement
    And User clicks Vehicles Tab and remove vehicle garaging address information
    And User finalizes transaction and clicks process <tc17316>
    And User clicks Policy File Chevron <tc17316>
    Then User clicks Endorsement Package link and validates form versions in Endorsement Package and completes test
    
    
    
    
    
    
    
    
    
    
    
