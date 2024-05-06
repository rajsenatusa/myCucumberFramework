##created on 09/22/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR403--HO6- UW - Company Cancellation - Reason Roof Disrepair - Reinstatement form_AIIC RI 11 14
## PRECONDITIONS (IF ANY): Active HO6  Policy - Use New Business UW Reports
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create HO6 NB Policy.
## 									 2. For company canellation. Start Transaction, Click Cancel then select a reason, Finalize
## 									 3. Reinstate the same way, change date to a future date, then Start Transaction to Reinstate.
## 									 4. Validate the correct Reinstatement form is attaching. 
  
## EXPECTED RESULTS: Policy is Cancelled & on reinstatement correct Reinstatement form is attaching to Policy File  
  
## User: Jbarnes

##note: There is a defect created by offshore team for this scenario. REIN NOTICE sample form in forms chevron is not opening. That part removed from code. It should be added after defect has been resolved. 

@regression @mtr403 @ho6regression @AIIho6
Feature: MTR403--HO6- UW - Company Cancellation - Reason Roof Disrepair - Reinstatement form_AIIC RI 11 14

  Scenario: Validate that Policy is Cancelled & on reinstatement correct Reinstatement form is attaching to Policy File 
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr403>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <mtr403>
    And User enters all required information on HO6 dwelling screen and enters <15.000> for CovC <mtr403>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <mtr403>
    And User checks application dwelling screen and finalizes transaction <mtr403>
    And User issues policy
    And User validates that HO6 policy has been created successfully and takes note of the policy number
    And User clicks Start Transaction
    And User clicks Cancellation Transaction Selection
    And User selects Cancellation Type as Company
    And User selects Roof Disrepair as reason
    And User selects Roof exceeds typical life expectancy as subreason
    And User selects effective date as cancel date 'current date plus 30 days' <mtr403>
    And User starts cancellation transaction
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User clicks Start Transaction
    And User clicks Reinstatement Transaction Selection
    And User clicks Start button and process transaction
    And User clicks Forms Chevron
    And User verifies AIIC RI 11 14 generated on Forms chevron <mtr403>
    And User clicks Policy File Chevron for <mtr403>
    And User validates Continuation of Coverage form has been displayed <mtr403>
    Then User clicks Continuation of Coverage form, saves it to local and do comparisions and validations <mtr403>
    
    
    
    
    
    
    
    
    
    