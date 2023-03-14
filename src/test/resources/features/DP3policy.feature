#Author: Can Yavas

Feature: Issuing DP3 policy

  @dp3
  Scenario: Valid DP3 policy creation
    Given I signin Spin as Standard Agent
    When I start transaction as a new customer
    And I enter all required information on customer information screen
    And I enter DP3 product selection information and effective date
    And I enter all required information on DP3 quote screen
    And I enter all required information on DP3 dwelling screen
    And I enter all required information on DP3 review screen
    And I create DP3 application
    Then I validate the DP3 policy has been created successfully
    
    
    @Regression @MTR537
	Scenario: MTR-537 Validate Owner Occupied NB Endorsement- NB INTEGRITY SELECT Text Builder
    Given I signin Spin as Standard Agent
    When  I enter Quote Information as effective date with "0" days difference and state "Florida" and "AI" Insurance Carrier group 
    And I select the product from Product Selection List as "DP3"
    And I select the entiry as "Individual"
    And I enter all required information on Insured information section
    And I fill the address details of "2525 US Highway 27 S" and "33825"
    And I enter all required information on DP3 quote screen
    And I enter all required information on DP3 dwelling screen
    And I select "Integrity Select" package
    And I validate the default value of "Cov-C" as "25%"
    And I validate the default value of "Home Computer" as "$2,500"
    And I validate the default value of "Cov-L" as "$100,000"
    And I enter all required information on DP3 review screen
    And I create DP3 application
    Then I validate the DP3 policy has been created successfully