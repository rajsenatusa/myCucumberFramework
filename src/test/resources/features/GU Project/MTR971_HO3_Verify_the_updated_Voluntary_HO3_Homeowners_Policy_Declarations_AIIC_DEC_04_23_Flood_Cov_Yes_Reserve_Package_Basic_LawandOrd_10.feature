## Author: Can Yavas
## created on 01/05/2024

## TEST CASE NUMBER & TITLE: MTR971--HO3, Verify the updated Voluntary HO3: Homeowners Policy Declarations AIIC DEC 04 23; Flood Cov-Yes, Reserve Package-Basic, Law and Ord -10%
## PRECONDITIONS (IF ANY): VOL HO3 NB eff  04/21/2023 and with flood coverage, basic reserve package, law and order as %10
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into Spin as an agent and create a VOL HO3 policy eff 04/21/2023
## 2.Enter all required information and select Flood coverage as YES, Basic reserve package, Law and Ord as 10%
## 3.Finalize Transaction with payment and go to Policy file
## 4.View Declaration Page, View the New Business package
## 5.Renew to 02 term and view the  RN  packet
## EXPECTED: Homeowers Policy Declarations AIIC DEC 04 23 generates with the following 
## AIIC DEC 04 23 displays on bottom of all pages  
## FORM content and formatting match clean copies attached to the US
## Form prints in the correct order as per FL HO3 Forms Matrix
  
## User: Standard Agent AG1730, underwriter1, admin
## updated on 02/05/2024 due to user access level. Agent is able to issue policy without approval


@regression @mtr971 @ho3regression @gu
Feature: MTR971--HO3, Verify the updated Voluntary HO3: Homeowners Policy Declarations AIIC DEC 04 23

  Scenario: Validate FORM content and formatting match clean copies attached to the US AIIC DEC 04 23 displays on  bottom of all pages

    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr971>
		And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr971>
		And User enters all required information on HO3 dwelling screen, adds flood cov, sets law order as 10 percent <mtr971>
		And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
		And User completes required information on dwelling chevron <mtr971>
    And User clicks Finalize button <mtr971>
    #And User takes note of the application for <mtr971>
    #And User clicks submit for approval button
    #And User signs out
    #And User login to Spin as Underwriter
    #And User searches for the application <mtr971>
    #And User approves application
    #And User signs out
    #And User login to Spin as Standard Agent
    #And User searches for the application <mtr971>   
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr971>
    And User searches for the policy number <mtr971>
    And User clicks Policy File Chevron <mtr971>
    And User clicks Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package <mtr971>
    And User clicks New Business Package Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package <mtr971>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the policy number <mtr971>
    And User clicks Start Transaction
    And User selects Renewal
    And User does manual renewal on the policy <mtr971>
    And User clicks Policy File Chevron <mtr971>
    Then User clicks Renewal Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package and completes test <mtr971>
    
    
    
    
    
    
    
    
    
    
    
    
    