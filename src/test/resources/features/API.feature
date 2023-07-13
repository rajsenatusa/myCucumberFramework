#Author: Can Yavas
@apimasterregression
Feature: Master Regression API Suite


Scenario: Validation DP3 Quote Process
    When I enter required information when creating quote and I validate response body for Quote Creation Confirmation
		

Scenario: Validation HO3 Quote Process
		When I enter required information when creating HO3 quote and I validate response body for Quote Creation Confirmation
		And I validate H03 Premium Rates and H03 Commission Calculations 
		

Scenario: Validation DP3 Application Process
		When  I enter required information when creating DP3 application and I validate below response body for Application Creation Confirmation
		And 	I validate DP3 Premium and Base Rates and DP3 Commission Calculations 
		

