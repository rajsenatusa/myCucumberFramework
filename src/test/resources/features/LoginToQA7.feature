#Author:Mustafa Cemek
@LoginToQA7
Feature: Login to QA7

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
    And User enters a valid user name"<username>"
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
      
