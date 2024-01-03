 # created on 12/20/2023 by Can Yavas

 # TEST CASE NUMBER & TITLE: TC 35236--UW, HO6, Validate when open Company cancellation is completed that it also applies the cancellation to the renewal term
 # PRECONDITIONS (IF ANY
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Validate when the open cancellation is completed that it also applies the cancellation to the renewal term
 # EXPECTED RESULTS: When the open cancellation is completed that it also applies the cancellation to the renewal term
  
 # User: AG1730


@regression @tc35236 @ho6regression
Feature: TC 35236--UW, HO6, Validate when open Company cancellation is completed that it also applies the cancellation to the renewal term

  Scenario: Validate that once the open cancellation is completed that it also applies the cancellation to the renewal term
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc35236>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <tc35236>
    And User enters all required information on HO6 dwelling screen and enters <25.000> for CovC <tc35236>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <tc35236>
    And User checks application dwelling screen and finalizes transaction <tc35236>
    And User issues policy
    And User validates that HO6 policy has been created successfully and takes note of the policy number <tc35236>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <tc35236>
    And User clicks Start Transaction
    And User clicks Cancellation Transaction Selection
    And User selects Cancellation Type as Company
    And User selects Failure to comply with underwriting requirements as reason <tc35236>
    And User selects Additional information required for underwriting review not provided as subreason <tc35236>
    And User selects effective date as cancel date 'current date plus 30 days' <tc35236>
    And User selects pro rate as cancel type and process transaction <tc35236>
    And User takes note of the application number <tc35236>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the policy number <tc35236>
    And User clicks Make Payment and selects credit card and enters due amount <tc35236>
    And User makes payment with Credit Card <tc35236>
		And User does Auto Renewal for the policy with batch jobs <tc35236>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for application number <tc35236>
    And User validates expected issue cancellation messages <tc35236>
    And User clicks Refresh button and validates 'conflict with changes made to the policy since this application was started. Expand to review' message displayed
    And User clicks Finalize button <tc35236>
		And User process and completes endorsement <tc35236>
    Then User opens Cancelled Policy Details and validates expected status and completes test
    
    
    