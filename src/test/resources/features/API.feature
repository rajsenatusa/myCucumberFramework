#Author: Can Yavas
@apimaster
Feature: Master Regression API Suite


Scenario: Validation DP3 Quote Process
    When I enter required information when creating quote and I validate response body for Quote Creation Confirmation
		

Scenario: Validation HO3 Quote Process
		When I enter required information when creating HO3 quote and I validate response body for Quote Creation Confirmation
		And I validate H03 Premium Rates and H03 Commission Calculations 