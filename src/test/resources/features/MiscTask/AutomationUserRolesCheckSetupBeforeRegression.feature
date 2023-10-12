##created on 09/28/2023 by Can Yavas

## this script needs to be run before each monthly regression tests starts and after model refresh!

## Add change date and site-admin button for users AG1730 - AG0376 - AG8166
## change password for AG0376 - AG8166 - AG1529A2
## Add adjuster 2 role to Adjuster2 usercode
## Add change date to Adjuster1 and Adjuster2 usercode
## Add claimmgr1 userrole from scratch
## add Underwriter role for the user Underwriter1 and remove underwriter manager role

## ps: code taking new passwords from configuration.properties file. Do not forget to update desired password there!

@beforeregression @automationsetup

Feature: Automation User Roles Check and Setup Before Each Regression

  Scenario: Validate all Users have correct attributes for upcoming regression tests
    Given User login to Spin as Admin Agent
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AG1730
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User scrolls to User Roles List
    And User clicks Override Link on Policy Agent Standard
    And User switches Site Admin Selection from No to Yes
    And User clicks save
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AGISA002537
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User scrolls to User Roles List
    And User clicks Override Link on Policy Agent Standard
    And User switches Site Admin Selection from No to Yes
    And User clicks save
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent CSRUW1
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent Underwriter1
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AG0376
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User scrolls to User Roles List
    And User clicks Override Link on Policy Agent Standard
    And User switches Site Admin Selection from No to Yes
    And User clicks save
    And User clicks Return button
    And User changes password for AG0376
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AG8166
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User scrolls to User Roles List
    And User clicks Override Link on Policy Agent Standard
    And User switches Site Admin Selection from No to Yes
    And User clicks save
    And User clicks Return button
    And User changes password for AG8166
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AG1529A2
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User scrolls to User Roles List
    And User clicks Override Link on Policy Agent Standard
    And User switches Site Admin Selection from No to Yes
    And User clicks save
    And User clicks Return button
    And User changes password for AG1529A2
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent Adjuster 2
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Adjuster 2 Role from roles dropdown
    And User clicks save
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent Adjuster1
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Change Date from role dropdown
    And User clicks save
    And User clicks Admin Tab 
    And User clicks User Management Tab
    And User clicks Add User
    And User enters all required information for claim manager role and creates user	
		And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent Underwriter1
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Add Role
    And User selects Underwriter Role from role dropdown
    And User clicks save
		And User scrolls to User Roles List
		And User deletes underwriter manager role from dropdown
		And User signs out
		
		
		
		