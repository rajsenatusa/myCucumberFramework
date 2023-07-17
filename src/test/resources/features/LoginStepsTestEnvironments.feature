#updated 07/17/2023 by Can Yavas
Feature: Login Functionality Testing for all Test Environments

  Scenario: Valid Login to Model Environment
    Given User navigates to the spin website
    When User enters a valid username
    And User enters a valid password
    And User clicks on the signin button
    Then User validates that logged in successfully
    And User quits the browser

  Scenario: Invalid Login to Model Environment
    Given User navigates to the spin website
    When User enters a valid username
    And User enters an invalid password
    And User clicks on the signin button
    Then User validates that Invalid Credentials is displayed
    Then User quits the browser

  @LoginToQA7-1
  Scenario: Login with valid credentials
    Given User navigates to QA7
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

  @LoginToQA7-2
  Scenario Outline: Login with valid credentials
    Given User navigates to QA7
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

    Examples: Test Data
      | username   | password |
      | AG1171     | password |
      | AG1529     | password |
      | AG6718     | password |
      | AG8134     | password |
      | AG0005     | password |
      | JLOWE      | password |
      | MKOZIEL    | password |
      | JFOSTER    | password |
      | PKNOWLES   | password |
      | DBEATTIE   | password |
      | TWilliamsD | password |
      | LZALANSKY  | password |
      | BSMITS     | password |
      | TWATSON    | password |
      | TCRENSHAW  | password |
      | Pmadigan   | password |
      | Wdennis    | password |
      | Zglover    | password |
      | Aallen     | password |
      | KJACOBI    | password |

  Scenario Outline: Valid Login with different Users
    Given User navigates to the spin website
    When Login with valid "<username>" and "<password>"
    And User clicks on the signin button
    Then User validates that logged in successfully
    And User quits the browser

    Examples: 
      | username | password |
      | ag1730   | password |
      | mkoziel  | password |
      | jfoster  | password |

  @LoginToQA6
  Scenario: Login with valid credentials
    Given User navigates to QA6
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

  @LoginToQA5
  Scenario: Login with valid credentials
    Given User navigates to QA5
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

  @LoginToQA4
  Scenario: Login with valid credentials
    Given User navigates to QA4
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

  @LoginToQA3
  Scenario: Login with valid credentials
    Given User navigates to QA3
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

  @LoginToQA2
  Scenario: Login with valid credentials
    Given User navigates to QA2
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

  @LoginToQA1
  Scenario: Login with valid credentials
    Given User navigates to QA1
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

  @LoginToModel
  Scenario: Login with valid credentials
    Given User navigates to Model
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser

  @LoginToModel2
  Scenario: Login with valid credentials
    Given User navigates to Model2
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User verifies that User logged in
    And User will quit the browser
