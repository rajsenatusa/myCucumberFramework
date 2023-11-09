##created on 11/08/2023 by Can Yavas

 # TEST CASE NUMBER & TITLE: TC 16741--DP1 Agent Basic Policy QT Validations - Validate error messages for DP1 Characteristics
 # PRECONDITIONS (IF ANY):
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Create DP1 policy to verify edit and error messages trigger on the Quote for the following conditions
 # County Closed for Business
 # Prior Carrier = None
 # Lapse in Coverage
 # Occupancy = Tenant
 # Occupancy = Vacant
 # Months Occupied = 0-3 Months 
 # Cov A = 1,700,000
 # Cov A = 100,000
 # AOP deductible higher than Wind/Hail Deductible (Other than Hurricane)
 # Limited Fungi, Mold, Wet or Dry Rot, or Bacteria*
 # Limited Carport(s), Pool Cage(s) and Screen Enclosure(s)*, Roof Cover
 # EXPECTED RESULTS: Edits, error or hard stops triggered in Quote status
  
 # User: AG1730
 ## **TEST CASE IS INEFFECTIVE. OWNER OCCUPIED SELECTION FOR DP1 IS NOT AVAILABLE ANYMORE. REMOVED FROM REGRESSION. USER STORY NEEDS TO BE UPDATED

 @tc16741
Feature: TC 16741--DP1 Agent Basic Policy QT Validations - Validate error messages for DP1 Characteristics

  Scenario: Validating Edits, error or hard stops are triggered in quote status
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
   	And User enters all required information on policy information screen with closed county address <tc16741>
   	And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen with Owner Occupied occupancy type <tc16741>
    And User validates 'County is closed for new business' text is visible <tc16741>
    And User starts transaction as a new customer
    And User creates new quote again <tc16741>
    And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen with Tenant Occupied occupancy type and monthly rented total 5 times and validates expected issue messages <tc16741>
    And User changes property managed selection as yes and months occupied as montly rented total 6 times and validates expected issue messages 
    And User changes Lease Term as Annual and selects Short Term Rental as Yes and validates expected messages
    And User sets prior carrier, expiration date as current date minus 50 days and validates expected issue messages
    And User sets prior carrier as new purchase removes expiration date sets occupancy as owner occupied 0 to 3 months and validates issue messages
    And User enters all required information on DP1 dwelling screen and validates expected issue messages <tc16741>
    And User sets CoverageA as <1.700.000> and other deductibles and validates issue messages
    And User sets CoverageA as <10.000> and other deductibles and validates issue messages
    And User sets CoverageA as <232.000> and other deductibles and validates issue messages
    And User sets Limited Cart Pool Cage Coverage and other deductibles and validates issue messages
    And User checks Wind Hail exclusion and validates issue messages
    Then User enters all required information on DP1 review screen and completes test
    
    
    
    