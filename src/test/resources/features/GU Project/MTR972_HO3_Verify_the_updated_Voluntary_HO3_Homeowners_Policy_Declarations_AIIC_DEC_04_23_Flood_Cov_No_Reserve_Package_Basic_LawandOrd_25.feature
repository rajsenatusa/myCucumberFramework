## Author: Can Yavas
## created on 01/05/2024

## TEST CASE NUMBER & TITLE: MTR972--HO3, Verify the updated Voluntary HO3: Homeowners Policy Declarations AIIC DEC 04 23; Flood Cov-No, Reserve Package-Basic, Law and Ord -25%
## PRECONDITIONS (IF ANY): VOL HO3 NB eff  04/21/2023 and without flood coverage, basic reserve package, law and order as %25
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into Spin as an agent and create a VOL HO3 policy eff 04/21/2023
## 2.Enter all required information and select Flood coverage as NO, Basic reserve package, Law and Ord as 25%
## 3.Finalize Transaction with payment and go to Policy file
## 4.View Declaration Page, View the New Business package
## EXPECTED: Homeowers Policy Declarations AIIC DEC 04 23 generates with the following 
## AIIC DEC 04 23 displays on bottom of all pages  
## FORM content and formatting match clean copies attached to the US
## Form prints in the correct order as per FL HO3 Forms Matrix
  
## User: Standard Agent AG1730, admin


@regression @mtr972 @ho3regression @gu
Feature: MTR972--HO3, Verify the updated Voluntary HO3: Homeowners Policy Declarations AIIC DEC 04 23

  Scenario: Validate FORM content and formatting match clean copies attached to the US AIIC DEC 04 23 displays on  bottom of all pages

    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr972>
		And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr972>
		And User enters all required information on HO3 dwelling screen, sets law order as 25 percent <mtr972>
		And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
		And User completes required information on dwelling chevron <mtr972>
    And User clicks Finalize button <mtr972>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr972>
    And User searches for the policy number <mtr972>
    And User clicks Policy File Chevron <mtr972>
    And User clicks Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package <mtr972>
    Then User clicks New Business Package Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package <mtr972>
    
    
    
    
    
    
    
    
    
    
    
    
    
    