## created on 10/12/2023 by Can Yavas
 
## TEST CASE NUMBER & TITLE: TC36681_HO3_ValidateRoofAgeLetterForRolledBitumen_RWL
## PRECONDITIONS (IF ANY)
## HIGH LEVEL STEPS OF TEST SCRIPT:  Validate that a home, that has a 10 year oldRolled/Bitumenat 
##                                   renewal,receives the letter for wind and X-Wind policies
## EXPECTED RESULTS: Validate that a home, that has a 10 year old rolled Bitumen roof at renewal receives the letter for wind and X-Wind policies 
 
## User: AG1777,Gallopadmin

@regression @tc36681
Feature: TC36681 HO3 Validate Roof Age Letter For RolledBitumen RENEWAL

  Scenario: Validate that a home, that has a 10 year old rolled Bitumen roof at renewal receives the letter for wind and X-Wind policies
    Given User login to Spin as Standard Agent