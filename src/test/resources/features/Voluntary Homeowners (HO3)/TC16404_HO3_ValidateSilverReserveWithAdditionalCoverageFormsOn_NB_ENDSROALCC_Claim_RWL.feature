## created on 10/10/2023 by Can Yavas
 
## TEST CASE NUMBER & TITLE: TC 16404--HO3 UW NB END (SRO & ALCC) Claim RN(2) Forms Silver Reserve with all additional Optional coverages
## PRECONDITIONS (IF ANY)
## HIGH LEVEL STEPS OF TEST SCRIPT:  Select Silver reserve coverage on new business by including all additional/ optional coverages,
##  								add Assisting living care & Structured rented to others coverages over endorsement transaction, 
## 									Create a claim on the policy and perform renewal
## EXPECTED RESULTS: All forms will be verified in the following states: 
## New Business
## Endorsement
## Claims
## Renewal transactions
  
## User: JLOWE

@regression @tc16404
Feature: TC 16404--HO3 UW NB END (SRO & ALCC) Claim RN(2) Forms Silver Reserve with all additional Optional coverages

  Scenario: Validate All forms will be verified in the following states
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16404>
    And User enters HO3 product selection information and new business date as effective date <tc16404>
		And User enters all required information on HO3 quote screen <tc16404>
		And User enters all required information on HO3 dwelling screen and selects silver reserve and add additional coverages <tc16404>
    And User enters all required information on HO3 review screen
    And User clicks Print button on quote and validates quote form version
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron and updates years updated sections <tc16404>
    And User clicks Finalize button <tc16404>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <tc16404>
    And User clicks Forms Chevron <tc16404>
    And User validates all expected forms to be listed 
    And User clicks greeting letter form and validates form version
    And User clicks privacy statement form and validates form version
    And User clicks deductible notification form and validates form version
    And User clicks limitation on roof form and validates form version
    And User clicks Policy Jacket form and validates form version
    And User clicks Home Owner Special form and validates form version
    And User clicks Home Cyber Protection form and validates form version
    And User clicks premise protective devices form and validates form version
    And User clicks Service Line coverage form and validates form version
    And User clicks Silver Coverage form and validates form version
    And User clicks Outline of Your Homeowners Policy form and validates form version
    And User clicks Checklist of Coverage form and validates form version
    And User clicks Hurricane Loss Mitigation form and validates form version
    And User clicks Notice of Consumer Reports form and validates form version
    And User clicks Policy File Chevron <tc16404>
    And User clics Application form and validates form version
    And User clicks Policy File Chevron <tc16404>
    And User clicks New Business Package form and validates form version
    And User searches for the policy number <tc16404>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as endorse date and starts endorsement <tc16404>
    And User clicks Dwelling Chevron <tc16404>
    And User adds Assisting Living Care
    And User adds Structure Rented to Others 
		And User clicks Finalize button and Endorses Policy <tc16404>
		And User clicks Forms Chevron <tc16404>
    And User validates all expected forms to be listed with new added endorsements
		And User clicks Assisted Living Care form and validates form version
		And User clicks Structures Rented to Others form and validates form version
		And User clicks Policy File Chevron <tc16404>
		And User clicks Endorsement Package and validates form versions
		And User signs out
		And User login to Spin as Claim CSR
		And User changes system date to endorsement date
		And User searches for the policy number <tc16404>
		And User clicks Report Loss
    And User sets loss date as endorse date <tc16404>
		And User selects loss cause as Collapse and clicks Save <tc16404>
		And User completes all required information on claim chevron <tc16404>
		And User clicks save and takes note of the loss number <tc16404>
    And User clicks Complete and takes note of the claim number <tc16404>
		And User clicks Forms Chevron <tc16404>
		And User validates all expected forms to be listed with new added claim
		And User signs out
		And User login to Spin as Admin Agent
		And User searches for the policy number <tc16404>
		And User clicks Make Payment and selects credit card and enters due amount <tc16404>
    And User makes payment with Credit Card for <tc16404>
		And User does Auto Renewal for the policy with batch jobs <tc16404>
		And User clicks Forms Chevron <tc16404>
		And User validates all expected forms to be listed with renewal
		And User clicks Policy File Chevron <tc16404>
		And User clicks Renewal Declaration form and validates form versions
		And User clicks Make Payment and do renewal payment
		
		
		
		
		
		
		
		
		
		
    