# Author: Mustafa Cemek
# created on 11/21/2023

  #TEST CASE NUMBER & TITLE: TC36633_HO3_RemoveRoofMaterialValidationRuleBasicNBasAgentandUWapproves_TarAndGravel
  #Precondition-Create a NB HO3 effective 4/23/22;Reserve Package - Basic ,Roof material: Tar and Gravel
  #HIGH LEVEL STEPS OF TEST SCRIPT:
  #Removing Tar and Gravel validation rule when the roof age/update is greater than or  equal to 16 years.     
  #EXPECTED RESULTS: Confirm that as an UW can approve an approval request on a risk with Tar and Gravel where the age of the roof is > 10 years.
  
  #User:AG1730
 

@regression @tc36633
Feature: TC36633_HO3_Remove Roof Material Validation

  Scenario: Remove Roof Material Validation
  
  
   Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc36633>
		And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <tc36633>
    And User enters all required information on HO3 dwelling screen <tc36633>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3 <tc36633>
    And User clicks Finalize button <tc36633>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <tc36633>
    
 
  