## created on 10/18/2023 by Can Yavas
 
## Title: GOC UW NB Validations - Gold Endorsement
  
## Preconditions: -
  
## High Level Steps -
## Golf Cart Coverages tile displays for Underwriter role. 
## Gold Endorsement is able to be selected when Liability, Other Than Collision, and Collision are selected. 
  
## User - underwriter1

@regression @tc17113
Feature: TC17113 GOC UW NB Validations - Gold Endorsement

  Scenario: Validate Gold Endorsement is able to be selected when Liability, Other Than Collision, and Collision are selected
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc17113>
    And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen <tc17113>
    And User enters all required information on GOC golfcart screen for <tc17113> and validates golf cart coverages dd defaulted values
    And User enters driver information on driver screen <tc17113>
    And User enters vehicles information on vehicles screen <tc17113> and do validations with different deductibles
    And User enters all required information on GOC review screen <tc17113>
    And User creates GOC application <tc17113>
    And User answers all underwriting questions for GOC
    And User validates expected dropdown values defaulted and expected elements disabled
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that GOC policy has been created successfully and takes note of the policy number <tc17113>
    Then User clicks Golf Cart Tab and validates all expected deductible and values and completes test
    
    
    
    
    