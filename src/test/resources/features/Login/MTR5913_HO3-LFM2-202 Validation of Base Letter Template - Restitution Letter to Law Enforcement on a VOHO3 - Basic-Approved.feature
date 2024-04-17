# Author: Mustafa Cemek
# created on 04/16/2024
#TEST CASE NUMBER & TITLE: MTR-5913-LFM2-202 Validation of Base Letter Template - Restitution Letter to Law Enforcement on a VOHO3 - Basic-Approved
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Builders base rate should be displayed for Water_nW, FireLightning, Liability, Other,Weather, Theft,CGCC, Hurricane correctly. County factor should be displayed correctly
#User: Standard Agent, 		Adjuster1
@regression @mtr5913 @lfm
Feature: MTR5913_Verify User is able to create "Restitution Letter to Law Enforcement" on a VOL HO3 claim and submitted Claim File

  Scenario: Verify User is able to edit the fields and see the Restitution Letter to Law Enforcement letter as pdf in Claim File
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr5913>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr5913>
    And User enters all required information on HO3 dwelling screen <mtr5913>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5913>
    And User signs out
    Given User login to Spin as Adjuster
    And User Searchs for Policy Number <mtr5913>
    And Use clicks Report Loss
     And User sets Loss Date as after 30 days from the current