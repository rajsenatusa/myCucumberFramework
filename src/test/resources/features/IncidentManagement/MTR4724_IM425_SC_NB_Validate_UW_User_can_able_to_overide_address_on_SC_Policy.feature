## Author: Can Yavas
## created on 02/13/2024

## TEST CASE NUMBER & TITLE: MTR4724--SC HO3, IM-425 : SC NB Validate UW User can able to overide address on SC Policy
## PRECONDITIONS (IF ANY): VOL SC HO3 NB 
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into SPIN as Underwriter
## 2.Enter address 1779 Moonseed Dr, Longs, Horry, SC 29568 on quote screen as wrong address
## 3.Click on Verify address link
## 4.Click on error message and click on Ignore Address validation
## EXPECTED RESULTS: No Error message is occurred and Policy issued

## User: Underwriter1, AG1777A1 


@regression @mtr4724 @scregression @im 
Feature: MTR4724--SC HO3, IM425 : SC NB Validate UW User can able to overide address on SC Policy

  Scenario: Validate UW is able to override address on SC NB HO3 policy

    Given User login to Spin as Underwriter
    When User clicks New Quote selects Product Line and Eff date as current date
    And User enters wrong address SC policy quote screen and validates error message and clicks ignore address validation <mtr4724>
    And User enters all required information on SC HO3 dwelling screen <mtr4724>
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr167>
    
    
    
    
    
    
    
    
    
    
    
    
    
    