## created on 10/12/2023 by Can Yavas
 
## TEST CASE NUMBER & TITLE: TC36681_HO3_ValidateRoofAgeLetterForRolledBitumen_RWL
## PRECONDITIONS (IF ANY)
## HIGH LEVEL STEPS OF TEST SCRIPT:  Validate that a home, that has a 10 year oldRolled/Bitumenat 
##                                   renewal,receives the letter for wind and X-Wind policies
## EXPECTED RESULTS: Validate that a home, that has a 10 year old rolled Bitumen roof at renewal receives the letter for wind and X-Wind policies 
 
## User: AG1777,Gallopadmin

@regression @tc36681 @mtr4585 @ho3regression
Feature: MTR4585- HO3 Validate Roof Age Letter For RolledBitumen RENEWAL

  Scenario: Validate that a home, that has a 10 year old rolled Bitumen roof at renewal receives the letter for wind and X-Wind policies
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc36681>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <tc36681>
    And User enters all required information on HO3 dwelling screen and select bitumen roof and  basic reserve package <tc36681>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <tc36681>
    And User clicks Finalize button <tc36681>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <tc36681>
    And User clicks Make Payment and selects credit card and enters due amount <tc36681>
    And User makes payment with Credit Card for <tc36681>
    And User renew policy to the next term through batch jobs
    And User clicks Policy File Chevron <tc36681>
    And User validates Roof Age Renewal Letter is visible and validates form version
    And User clicks Make Payment and do renewal payment <tc36681>
    And User renew policy to the third term through batch jobs
    And User clicks Policy File Chevron <tc36681>
    Then User validates Roof Letter is visible and completes test
    
    
    
    
    
    
    
    
    