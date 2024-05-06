# Author: Mustafa Cemek
# created on 03/26/2024
#TEST CASE NUMBER & TITLE: MTR-521-JVerify HO3 policy Agent can perform  END TX, Change Reserve Package, Increase CovA, Change Deductible
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: Select "Gold Reserve" fo Reserve Package*Increase A-Dwelling* by $60,000 Select "$2,000" for Deductible (AOP)* Select "4%" for the Deductible (Hurricane)* Select "$2,000" for Wind/Hail Deductible (Other than Hurricane)*
#EXPECTED RESULTS: Policy is sent to UW approval and endorsed by agent
#User: Standard Agent, UW
@regression @mtr521 @gu 
Feature: MTR521 HO3 Policy can be endorsed by agent after UW approval

  Scenario: Validate HO3 Policy is endorsed with Gold Reserve, A-Dwelling, Deductible (AOP), Deductible (Hurricane), Wind/Hail Deductible and Additional Interest changes by agent after UW approvel
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr522>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr400>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr400>
    And User enters all required information on HO3 dwelling screen <mtr521>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr521>
    And User clicks Additional Interests chevron
    And User clicks Add Additional Interest button
    And User enters Additional Interest Detail
    And User clicks Save button
    And User clicks Finalize button
    And User clicks Finalize button <mtr400>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr400>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User selects endorsement date as system date plus 30 days
    And User clicks Dwelling chevron
    And User enters on HO3 dwelling screen and enters <Gold Reserve>
    And User clicks Additional Interests chevron
    And User clicks Delete hyperlink
    And User clicks Add Additional Interest button
    And User enters Additional Interest Detail
    Then User validates ChangeDeleteCopy hyperlinks display
    And User clicks Save button
    And User clicks Finalize button
    And User takes note of the application number <mtr530>
    And User submits the application for UW approval
    Then User validates the Application is submitted for approval
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Application Number for <mtr530>
    And User clicks approve button <mtr530>
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Application Number for <mtr530>
    And User clicks Endorse Policy button
    And User clicks History Chevron
    And User clicks plus button Next to Endorsement on the Transaction History
    Then User validates Endorsement Changes <mtr530>
