#Author: Can Yavas
##created on 10/19/2023

# TEST CASE NUMBER & TITLE: TC38507: US 8918: DP1 RULE - Metal/Tile roof material age change - NB = 25 years
# Precondition-Issue NB effective 07/01/2022,MMA =No
# HIGH LEVEL STEPS OF TEST SCRIPT:  

# EXPECTED RESULTS:Agent can issue DP1 policy without referral
 
# User:AG1730


@regression @tc38507
Feature: TC38507: US 8918: DP1 RULE - Metal/Tile roof material age change - NB = 25 years

  Scenario: Validating that Agent can issue DP1 policy without referral
    Given User login to Spin as Admin Agent