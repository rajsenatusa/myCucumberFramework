##created on 11/06/2023 by Can Yavas

# TEST CASE NUMBER & TITLE: TC 16742--AIB Agent Basic Policy QT Validations - Validate error messages for AIB Characteristics
# PRECONDITIONS (IF ANY): NA
# HIGH LEVEL STEPS OF TEST SCRIPT:  
# Validating that edit and error messages appears are triggered for the following in quote status.....
#	a Operator is less than 21 years old,
#	when Boat is greater than $200,000,
#	Boat Storage address not in Florida
#	Boat has existing damage,  
#	Maximum Speed is 61 mph or faster
#	Boat is stored in a closed for business county
#	Hull Type*=Houseboat ,Trawler or Airboat
#	Boat has more than 4 Owners
# EXPECTED RESULTS: Edits, error or hard stops are triggered in quote status 
  
# User: AG1730


@regression @tc16742
Feature: TC 16742--AIB Agent Basic Policy QT Validations - Validate error messages for AIB Characteristics

  Scenario: Validating Edits, error or hard stops are triggered in quote status
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc16742>
		And User enters AIB product selection information and current date as effective date
    And User enters all required information on AIB quote screen for <tc16742>
    And User validates 'County is closed for new business' text is visible
    And User changes ineligible address with eligible address
    And User selects Combined Single Limit liability coverage on quote screen for <tc16742>
    And User adds operator information on quote screen <tc16742>
    And User enters all required information with negative scenario inputs on AIB boat dwelling screen and validates expected error messages <tc16742>
    And User changes hull type, storage location and validates expected error messages
    And User adds second boat with negative inputs and validates expected error messages
    And User adds operator for second boat and validates expected issue messages
    And User clicks first boat link and select primary operator 
    And User clicks second boat link and select primary operator and validates expected issue messages
    And User clicks Additional Interest Chevron
    And User clicks Add Additional Interest button
    And User completes required information on add additional interests screen and adding first mortgagee and validates expected error messages <tc16742>
    And User adds additional interest for 3 more times and validates expected issue messages
    Then User enters all required information on AIB review screen validates expected error messages and completes test <tc16742>
    
    
    
    
    
    
    
    
    
    