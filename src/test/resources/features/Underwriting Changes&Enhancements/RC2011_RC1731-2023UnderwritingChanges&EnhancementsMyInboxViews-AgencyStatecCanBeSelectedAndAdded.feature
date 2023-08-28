#Author:Mustafa Cemek
@UnderwritingChanges&Enhancements
Feature: RC-1731: 2023 Underwriting Changes/Enhancements: My Inbox Views- Add Agency State

  @UnderwritingChanges-AddAgencyState
  Scenario Outline: RC-2011: 2023 Underwriting Changes/Enhancements: My Inbox Views- Agency State can be selected and added
    Given User navigates to QA2
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    And User clicks on More button
    And User clicks on My Inbox Views
    And User clicks on Add Inbox View button
    And User enters a Name to View
    And User clicks on Agency State in Available Columns
    And User clicks on the Arrow
    And User selects the Work Date
    And User clicks Save
    And User clicks Return to Home button
    And User clicks on Current Open
    And User selects the Name in View
    And User clicks on Refresh Inbox
    Then User verifies Agency State can be selected and added

    Examples: Test Data
      | username | password  |
      | JLowe    | Aug@2023! |
