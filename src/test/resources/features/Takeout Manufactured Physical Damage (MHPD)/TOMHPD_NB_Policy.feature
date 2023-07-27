#Author: Can Yavas
#updated on 07/19/2023 by C.Yavas
#added datatable on 07/25/2023 by C.Yavas
Feature: Issuing TOMHPD policy

  @smoke @tomhpd
  Scenario: Valid TOMHPD policy creation
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHPD and effective date
    And User enters all required information on TOMHPD quote screen
    And User enters all required information on TOMHPD dwelling screen
    And User enters all required information on TOMHPD review screen
    And User creates TOMHPD application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TOMHPD policy has been created successfully

  @tomhpdSO
  Scenario Outline: Valid TOMHPD policy creation with Scenario Outline
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHPD and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User selects Building Territory List "<TerritoryList>"
    And User clicks CoverageA tab and enters Coverage A value "<CoverageA>"
    And User selects Attached Structures "<AttachedStructures>"
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TOMHPD review screen
    And User creates TOMHPD application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TOMHPD policy has been created successfully

    Examples: Test Data
      | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA |
      | 07/25/2023    | Owner Occupied | 9 to 12 Months |               2021 |             5 | No                 |    120000 |

   @tomhpddatatable
   Scenario: TO MHPD policy creation with multiple customers
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    Then User creates TOMHPD policy with passing information from excel "tomhpdcustomerInfo" sheet
    ##User can change or add new customer with the help of excel data table contents from /testdata folder from TOMHPD.xlsx
		##Do not change coloumn