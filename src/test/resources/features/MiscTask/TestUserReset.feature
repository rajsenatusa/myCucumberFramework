##updated on 07/17/2023 by Can Yavas
#user password reset by object of arrays have been added on 12/06/23 by Can Yavas

Feature: Reset Users

  @TestUser_Reset
  Scenario: Reset Password for Test user
    Given User logins with valid "pvispute" and "April@2023!"
    When User clicks on the login button
    And User processes all test user list to reset the password

  @userpasswordreset  @beforeregression
  Scenario: Reset Password for Test Users with Object Arrays
		Given User login to Spin as Admin Agent
		Then User processes all test users password changes with desired