#Author: Can Yavas
#updated on 07/18/2023
#datatable added on 07/24/2023 by C.Yavas
Feature: Issuing TODP1 policy

  @todp1 @smoke
  Scenario: Valid TODP1 policy creation
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP1 and effective date
    And User enters all required information on TODP1 quote screen
    And User enters all required information on TODP1 dwelling screen
    And User enters all required information on TODP1 review screen
    And User creates TODP1 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TODP1 policy has been created successfully
	
	@todp1so
  Scenario Outline: Valid TODP1 policy creation with Scenario Outline
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP1 and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User selects Distance to Hydrant "<DistanceHydrant>"
    And User selects Protection Class "<ProtectionClass>"
    And User selects Dwelling Type "<DwellingType>"
    And User selects Building Territory List "<TerritoryList>"
    And User clicks Save
    And User selects Quality Grade "<QualityGrade>"
    And User clicks Calculate Button 
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TODP1 review screen
    And User creates TODP1 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TODP1 policy has been created successfully
    
    Examples: Test Data
      | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | DistanceHydrant | ProtectionClass | DwellingType  | TerritoryList | QualityGrade | 
      | 01/01/2024    | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 | <= 1,000 Feet   |              04 | Single Family | 5             | Economy      | 
    

    @todp1datatable
   Scenario: TO DP1 policy creation with multiple customers
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    Then User creates TODP1 policy with passing information from excel "todp1customerInfo" sheet
    ##User can change or add new customer with the help of excel data table contents from /testdata folder from TODP1.xlsx
		##Do not change coloumn