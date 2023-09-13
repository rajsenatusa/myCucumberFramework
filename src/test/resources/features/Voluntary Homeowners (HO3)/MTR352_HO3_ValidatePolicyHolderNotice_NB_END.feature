##created on 09/13/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC36506 : US8592 - FORM: Policyholder Notice AIIC HO3 PHN CSAU 11 21 - HO3 - NB on 04/22/2022 and displays on END
## HIGH LEVEL STEPS OF TEST SCRIPT:
## EXPECTED RESULTS: Validate the Policyholder Notice form AIIC HO3 PHN CSAU 11 21 is included with the NB, RN package
##  and placement
## User:AG1730

@regression @mtr352
Feature: TC36506 : US8592 - FORM: Policyholder Notice AIIC HO3 PHN CSAU 11 21 - HO3 - NB on 04/22/2022 and displays on END

  Scenario: Validate the Policyholder Notice form AIIC HO3 PHN CSAU 11 21 is included with the NB, RN package
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr352>
    And User enters HO3 product selection information and current date as effective date
		And User enters all required information on HO3 quote screen <mtr352>
		And User enters all required information on HO3 dwelling screen <mtr352>
		And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User validates MMA selection defaulted to No
    And User completes required information on dwelling chevron <mtr352>
    And User clicks Forms Chevron <mtr352>
    And User validates 'AIIC HO3 PHN CSAU 11 21' form is visible
    And User clicks Finalize button <mtr352>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr352>
    And User clicks Forms Chevron <mtr352>
    And User validates 'AIIC HO3 PHN CSAU 11 21' form is visible
    And User clicks 'AIIC HO3 PHN CSAU 11 21' form and do validations
    And User clicks Policy File Chevron <mtr352>
    
    
    
    
    
    
    