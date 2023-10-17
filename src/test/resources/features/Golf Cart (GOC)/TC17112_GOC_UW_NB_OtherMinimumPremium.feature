## created on 10/17/2023 by Can Yavas
 
## Title: GOC UW NB Other - Minimum Premium
## Preconditions: -

## High Level Steps -
## 1. Login as UW
## 2. Create New Quote
## 3. Rate Area: Increase to Minimum Premium section displays on Worksheets tile
  
## User - Jlowe

@regression @tc17112
Feature: TC17112 GOC UW NB Other - Minimum Premium

  Scenario: Validate Increase to Minimum Premium section displays on Worksheets tile
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc17112>
    And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen <tc17112>
    And User enters all required information on GOC golfcart screen for <tc17112>
    And User enters driver information on driver screen <tc17112>
    And User enters vehicles information on vehicles screen <tc17112>
    And User enters all required information on GOC review screen <tc17112>
    And User validates 'Rate Area: Increase to Minimum Premium' is visible
    And User creates GOC application <tc17112>
    And User answers all underwriting questions for GOC
    And User clicks Worksheets Chevron
    And User validates 'Rate Area: Increase to Minimum Premium' is visible on application level
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that GOC policy has been created successfully and takes note of the policy number <tc17112>
    And User clicks Worksheets Chevron
    Then User validates 'Rate Area: Increase to Minimum Premium' is visible on policy level
    
    
    
    
    
    
    
    