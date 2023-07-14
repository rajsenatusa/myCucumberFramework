#Author: Can Yavas
#updated on 07/14/2023
Feature: Issuing DP3 policy

  @dp3 @smoke
  Scenario: Valid DP3 policy creation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters DP3 product selection information and effective date
    And User enters all required information on DP3 quote screen
    And User enters all required information on DP3 dwelling screen
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that DP3 policy has been created successfully
    
    
    @Regression @MTR537
	Scenario: MTR-537 Validate Owner Occupied NB Endorsement- NB INTEGRITY SELECT Text Builder
    ## Given I signin Spin as Standard Agent
    #When  I enter Quote Information as effective date with "0" days difference and state "Florida" and "AI" Insurance Carrier group 
    #And I select the product from Product Selection List as "DP3"
    #And I select the entiry as "Individual"
    #And I enter all required information on Insured information section
    #And I fill the address details of "2525 US Highway 27 S" and "33825"
    #And I enter all required information on DP3 quote screen
    #And I enter all required information on DP3 dwelling screen
    #And I select "Integrity Select" package
    #And I validate the default value of "Cov-C" "Building.CovCLimitIncluded" as "25%"
    #And I validate the default value of "Home Computer" "Building.CovHCCLimit" as "$2,500"
    #And I validate the default value of "Cov-L" "Building.CovLLimit" as "$100,000"
    #And I enter all the information on DP3 review screen
    #And Navigate to Policy tab
    #And I select Tenent occupied and navigate to dwelling page
    #And I validate the following message should display "Occupancy has been updated which would impact the prior coverages selected. Please review the coverages on the Dwelling page"
    #And I validate the default value of "Home Computer" "Building.CovHCCLimit" as "None"
    #And I validate the default value of "Cov-L" "Building.CovLLimit" as "$0"
    #And I change date of system "03/14/2023"
    #Given User search for "AGD30000632-01"
    #And Navigate to Policy tab
    #And I select Owner occupied and navigate to dwelling page
    #And I select "Integrity Select" package
    #And I create application of DP3   
    #And I fill all the DP3 uw questions
    #And I validate the default value of "Cov-C" "Building.CovCLimitIncluded" as "25%"
    #And I validate the default value of "Home Computer" "Building.CovHCCLimit" as "$2,500"
    #And I validate the default value of "Cov-L" "Building.CovLLimit" as "$100,000"
    #And I finalize and issue new business
    #Then I validate the DP3 policy has been created successfully
    #And I start transaction on policy
    #And I select endorsement transaction on "03/14/2023"
    
    
    
    
    
    
    
    
    
    
    
    
    