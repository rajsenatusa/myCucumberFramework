##created on 03/25/2024 by Mustafa Cemek
## TEST CASE NUMBER & TITLE: MTR530--Verify HO6 policy , Agent can perform , END TX, Change Reserve Package, Increase CovA, Change Deductible, Add 1st Mortgagee, UW Approval
## PRECONDITIONS (IF ANY): Active HO6 Basic Reserve Policy and Cov C-Personal Property=$25,000
## HIGH LEVEL STEPS OF TEST SCRIPT:  Validating As a Sales Agent, I would like the ability to update/endorse a policy
#HO6, Agent, END TX, Change Reserve Package, Increase CovA, Change Deductible, Add 1st Mortgagee, UW Approval
## EXPECTED RESULTS: Policy is sent to UW approval and endorsed by agent
## User: Standard Agent,  UW
@regression @mtr530 @gu
Feature: MTR530--HO6 Policy can be endorsed by agent after UW approval

  Scenario: Validate HO6 Policy is endorsed with Coverage A - Dwelling + Coverage C - Personal Property Limits and Additional Interest changes by agent after UW approvel.
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr407>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr407>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <mtr407>
    And User enters all required information on HO6 dwelling screen and enters <25.000> for CovC <mtr530>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <mtr407>
    And User checks application dwelling screen and finalizes transaction <mtr407>
    And User issues policy
    And User validates that HO6 policy has been created successfully and takes note of the policy number <mtr530>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User selects endorsement date as system date plus 30 days
    And User clicks Dwelling chevron
    And User enters on HO6 dwelling screen and enters <Silver Reserve>
    And User clicks Policy Chevron
    Then User validates messages in Issues
    And User clicks Additional Interests chevron
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
    Then User validates the Submitter Issues <mtr530>
    And User clicks approve button <mtr530>
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Application Number for <mtr530>
    And User clicks Endorse Policy button
    And User clicks History Chevron
    And User clicks plus button Next to Endorsement on the Transaction History
    Then User validates Endorsement Changes <mtr530>
