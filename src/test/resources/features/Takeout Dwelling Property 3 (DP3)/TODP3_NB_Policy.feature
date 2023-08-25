#Author: CanYavas
#updated on 07/18/2023 by C.Yavas
#added datatable on 07/24/2023 by C.Yavas
Feature: Issuing TODP3 policy

  @smoke @todp3 @healthcheck
  Scenario: Valid TODP3 policy creation
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP3 and effective date
    And User enters all required information on TODP3 quote screen
    And User enters all required information on TODP3 dwelling screen
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects roof material
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TODP3 policy has been created successfully
    
	@todp3so
  Scenario Outline: Valid TODP3 policy creation with Scenario Outline
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP3 and "<EffectiveDate>"
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
    And User selects Number of Units "<NumberOfUnits>"
    And User selects Building Territory List "<TerritoryList>"
    And User clicks Save
    And User selects Quality Grade "<QualityGrade>"
    And User clicks Calculate Button 
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects roof material
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TODP3 policy has been created successfully
    
    Examples: Test Data
      | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | DistanceHydrant | ProtectionClass | DwellingType  | NumberOfUnits |TerritoryList | QualityGrade | 
      | 07/25/2023    | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 | <= 1,000 Feet   |              04 | Single Family | 2             |5             | Economy      | 
    
     @todp3datatable
   Scenario: TO DP3 policy creation with multiple customers
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    Then User creates TODP3 policy with passing information from excel "todp3customerInfo" sheet
    ##User can change or add new customer with the help of excel data table contents from /testdata folder from TODP3.xlsx
		##Do not change coloumn