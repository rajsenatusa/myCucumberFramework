# Author: Mustafa Cemek
# created on 12/13/2023
#TEST CASE NUMBER & TITLE: MTR2988--IM-318 : HO6 NB END Validate WBU Coverage when the AOP is 500 shows $1,000 limit
#PRECONDITIONS (IF ANY): Current HO6  policy
#HIGH LEVEL STEPS OF TEST SCRIPT:  Verify that a policy with WBU Coverage where the AOP is 500 shows a 1,000 WBU
#deductible in the Coverage List of the Dwelling page.
#EXPECTED RESULTS: Policy with WBU Coverage where the AOP is 500 shows a 1,000 WBU deductible in the Coverage List
#of the Dwelling page.
#User: Aallen
@regression @mtr2988 
Feature: MTR2988--IM-318 : HO6 NB END Validate WBU Coverage when the AOP is 500 shows $1,000 limit

  Scenario: MTR2988_HO6_NB_END_WBUCoverageLimitshows1000whenAOPis500
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen for <mtr2988>
    And User enters HO6 product selection information and current date as effective date
    And User enters Producer Code for <mtr2988>
    And User enters all required information on HO6 quote screen with current date as prior policy date
    And User enters all required information on HO6 dwelling screen for <mtr2988>
    Then User validates Water Back Up and Sump Overflow as <$5,000> on Quote
    And User enters all required information on HO6 review screen
    Then User validates Quote Made
    And User creates HO6 application
    And User answers all underwriting questions for <mtr2988>
    Then User validates Water Back Up and Sump Overflow as <$5,000> on Application
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    When User enters Endorsement Effective Date for <mtr2988>
    And User clicks Dwelling chevron
    And User Modifies AOP for <mtr2988>
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User finishes test <mtr2988>
