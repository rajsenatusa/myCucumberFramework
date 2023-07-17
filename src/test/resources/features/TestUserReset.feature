##updated on 07/17/2023 by Can Yavas

Feature: Reset Users
 @TestUser_Reset
 Scenario: Reset Password for Test user
Given User logins with valid "pvispute" and "April@2023!"
When User clicks on the login button
And User processes all test user list to reset the password
    
