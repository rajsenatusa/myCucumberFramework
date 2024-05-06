##created on 04/01/2024 by Can Yavas

##TEST CASE NUMBER & TITLE: MTR592-HO3-Verify that an UW and above can approve the referal so the agent can issue the policy
  
## PRECONDITIONS (IF ANY): Application in Pending Approval status for "Risk is ineligible due to age of Plumbing" (Risk address has YOC and plumbing greater than 20 years old).
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  Validating that plumbing age > 20 years will  generate 
## 'Risk is ineligible due to Age of Plumbing' message  
   
## EXPECTED RESULTS: 
## 1.Validate that homes where the age of home is greater than 20 years and the age of plumbing is greater than 20 years display the message
## 2.Validate when the message appears the agent can refer. 
## 3.Validate that the message appears on the dwelling page after a year that is greater than 20 years is present
## 4.Validate that the message  appears on the dwelling page if the plumbing age is updated to be > 20 years 
## 5.Validate than an UW and above can approve the referal so the agent can issue the policy
## 6.Validate the agent can issue the approved application
  
## User: underwriter1



@mtr592 @regression @ho3regression @gu 
Feature: MTR592-HO3-Verify that an UW and above can approve the referal so the agent can issue the policy

  Scenario: Validate that homes where the age of home is greater than 20 years and the age of plumbing is greater than 20 years display the message
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr592>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr592>
    And User enters all required information on HO3 dwelling screen <mtr592>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron and validates 'Risk is ineligible due to age of Plumbing' text is visible <mtr592>
    And User finalizes transaction for VOL HO3 and validates 'Risk is ineligible due to age of Plumbing' text is visible <mtr592>
    And User takes note of the application number <mtr592>
    And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Admin Agent
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Underwriter
    And User clicks Search button
    And User scrolls to User Roles List
    And User clicks Override Link on Underwriter Role <mtr592>
    And User override Underwriters 'Allow to Approve Age of Plumbing' as no
    And User signs out
    And User login to Spin as Underwriter
    And User searches for application number <mtr592>
    And User clicks Finalize button
    And User validates 'Issue New Business' is not visible on closeout screen
    And User validates 'Approve' is not visible on closeout screen
    And User validates 'Submit for Approval' is visible on closeout screen
    And User validates 'Modify Application' is visible on closeout screen
    And User signs out
    And User login to Spin as Admin Agent
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Underwriter
    And User clicks Search button
    And User scrolls to User Roles List
    And User clicks Override Link on Underwriter Role <mtr592>
    And User override Underwriters 'Allow to Approve Age of Plumbing' as yes
    And User signs out
    And User login to Spin as Underwriter
    And User searches for application number <mtr592>
    And User validates 'Issue New Business' is visible on closeout screen
    And User validates 'Approve' is visible on closeout screen
    And User validates 'Submit For Approval' is not visible on closeout screen
    And Underwriter User clicks Approve Button <mtr592>
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for application number <mtr592>
    And User selects payment type and issues policy <mtr592>
    
    
    
    
    
    