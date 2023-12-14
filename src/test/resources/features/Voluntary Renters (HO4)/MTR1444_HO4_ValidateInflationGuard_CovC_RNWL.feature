##created on 11/29/2023 by Can Yavas

# TEST CASE NUMBER & TITLE: TC 38731--S 9452:VOL HO4 FL - 2022 Inflation Guard: High Value RN eff 09/19/2022
# PRECONDITIONS (IF ANY): HO4 Policy eff 09/19/2021 with different Coverages and Cov C being $210K
# HIGH LEVEL STEPS OF TEST SCRIPT:  Cov C on 2022 term increases by 10%
  
# EXPECTED RESULTS: When renewed to 2022 term, Cov C increases by 10% 
##note: On User story it is written as cov C increases by %25. But in model environment it is observed %10 increase. That needs to be checked by BA later.
 
# User: UW(underwriter1)

@regression @mtr1444 @ho4regression
Feature: TC 38731--S 9452:VOL HO4 FL - 2022 Inflation Guard: High Value RN eff 09/19/2022

  Scenario: Validate that once renewed to 2022 term, Cov C increases by 10%
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr1444>
    And User enters HO4 product selection information and effective date as current date
    And User enters all required information on HO4 quote screen <mtr1444>
    And User enters all required information and sets Coverage C as '210000'on HO4 dwelling screen <mtr1444>
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction <mtr1444>
    And User issues policy
    And User validates that HO4 policy has been created successfully and takes note of the policy number <mtr1444>
    And User clicks Make Payment and selects credit card and enters due amount <mtr1444>
    And User makes payment with Credit Card <mtr1444>
    And User does auto renewal through batch jobs <mtr1444> 
    And User clicks Dwelling Chevron <mtr1444>
    And User validates Inflation Guard Label is visible and expected value <231.000> displayed
    And User clicks Policy File Chevron <mtr1444>
    Then User clicks Renewal Declaration and validates form version and completes test <mtr1444>
    
    
    
    
    
    
    
    
    
    
    
    
    
    