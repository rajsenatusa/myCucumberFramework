#Author: Can Yavas
#created on 08/01/2023
@regression @tc38486
Feature: TC 38486--DP3, Update Cov C selection list - NB Owner Occupied ; after Integrity Select

  Scenario: As an Agent, validate Cov-C options list will display on NB for Integrity Select package when
    Occupancy=Owner Occupied and will not display for Package=Basic Policy on END

    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date
    And User enters all required information on DP3 dwelling screen and selects integrity select package
		And User validates Coverage C defaults to %25 on integrity select package
		And User validates Cov C drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70%