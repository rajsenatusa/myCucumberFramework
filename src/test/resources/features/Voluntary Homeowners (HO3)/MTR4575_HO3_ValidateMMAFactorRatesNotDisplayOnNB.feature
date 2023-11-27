## created on 11/27/2023 by Can Yavas
 
 # TEST CASE NUMBER & TITLE: TC38455_HO3_ValidateMMAFactorRatesNotDisplayOnNB
 # Precondition-Issue HO3 NB policy Effective 4/22/2022,MMA=No,Silver Package
 # HIGH LEVEL STEPS OF TEST SCRIPT:
 # Validate the Rates appear in the Rates.xml
 # Validate Rates display on rating worksheet when applicable
 # Validate rating 
 # Rating will display in the worksheet by peril rating under the base premium section for Water Non-Weather, Fire or Lightning, Liability, Other, Weathers, Theft, Catastrophic Ground Cover Collapse perils either before or after the ACV Roof Settlement Factor,
 # Rating for Hurricane Peril will display after the BCEG factor in the base premium section  

 # EXPECTED RESULTS:Validate Mandatory Mediation-Arbitration Coverage factor will not display on NB and displays on END
  
 # User: AG1730

@regression @mtr4575
Feature: TC38455 HO3 Validate MMA Factor Rates Not Display On NB

  Scenario: Validate Mandatory Mediation-Arbitration Coverage factor will not display on NB and displays on END
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr4575>
    And User enters HO3 product selection information and current date as effective date <mtr4575>
    And User enters all required information on HO3 quote screen <mtr4575>
    And User enters all required information on HO3 dwelling screen <mtr4575>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr4575>
    And User clicks Finalize button <mtr4575>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr4575>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr4575>
    And User clicks Worksheets Chevron
    And User validates MMA rate factors on NB level
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the policy number <mtr4575>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date and starts endorsement <mtr4575>
    And User clicks Dwelling Chevron <mtr4575>
    And User sets MMA selection as Yes <mtr4575>
    And User clicks Finalize button and Endorses Policy <mtr4575>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr4575>
    And User clicks Worksheets Chevron
    Then User validates MMA rate factors on EN level and completes test
    
    
    