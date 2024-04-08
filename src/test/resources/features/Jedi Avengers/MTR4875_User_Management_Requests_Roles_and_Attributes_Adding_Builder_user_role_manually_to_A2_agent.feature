##created on 03/14/2024 by Mustafa Cemek

# TEST CASE NUMBER & TITLE: MTR4875_JA-276 User Management Requests - Roles and Attributes:  Adding Builder user role manually to A2 agent
# PRECONDITIONS (IF ANY):
# HIGH LEVEL STEPS OF TEST SCRIPT:  Validate agent added with new user role
# EXPECTED RESULTS: Validate: Assisted Living Care Coverage: Yes, A Structure rented to others change:Yes,  Ordiance or Law change: Yes, Approve No Insurance Score, Dwelling - Allowed To Approve Address Change:Yes,
# Dwelling - Allowed To Approve Name Change:Yes, Dwelling - Allowed To Approve New Business:Yes, Dwelling - Maximum Coverage A Change Allowed:Yes, Homeowners - Allowed To Approve Address Change:Yes, Homeowners - Allowed To Approve Name Change:Yes,
# Homeowners - Maximum Coverage A Change Allowed:Yes, ISO Location Return Override:Yes, ISO Location Return Override:Yes, ISO Location Return Override:Yes

# User: AG8134, Admin Agent
@mtr4875 @regression @ja1 @ja
Feature: MTR4875-Validate Standard Agent can edit and modify Roles and Attributes

  Scenario: Validate that standard agent allowed to edit and modify the Roles and Attributes
    Given User login to Spin as Admin Agent
    When User clicks Admin Tab
    And User clicks User Management Tab
    And User searches Agent AG8134
    And User clicks user code as AG8134A2 and validates agent code will display
    And User scrolls to User Roles List
    And User clicks Override Link on Policy Agent Standard and validates Override Link
    And User validates for the attribute of 'Can the User Approve Assisted Living Care Coverage' selected as Yes
    And User validates for the attribute of 'Homeowners, Can the user approve an Structure rented to others change?' selected as Yes
    And User validates for the attribute of 'Can the user approve an Ordiance or Law change?' selected as Yes
    And User validates for the attribute of 'Allowed To Approve No Insurance Score' selected as Yes
    And User validates for the attribute of 'Dwelling - Allowed To Approve Address Change' selected as Yes
    And User validates for the attribute of 'Dwelling - Allowed To Approve Name Change' selected as Yes
    And User validates for the attribute of 'Dwelling - Allowed To Approve New Business' selected as Yes
    And User validates for the attribute of 'Dwelling - Maximum Coverage A Change Allowed'
    And User validates for the attribute of 'Homeowners - Allowed To Approve Address Change' selected as Yes
    And User validates for the attribute of 'Homeowners - Allowed To Approve Name Change' selected as Yes
    And User validates for the attribute of 'Homeowners - Maximum Coverage A Change Allowed'
    And User validates for the attribute of 'ISO Location Return Override' selected as Yes
    And User validates for the attribute of 'Homeowners - Allow acreage greater than 5' selected as Yes
    And User validates for the attribute of 'The maximum number of days a user can back date an insured request cancellation without approval'
    And User validates for the attribute of 'Allow Approve Capacity - minimum Coverage A' selected as Yes
    And User validates for the attribute of 'Allow approve Capacity - loss causes' selected as Yes
    And User validates for the attribute of 'ApproveHVACUpdate' selected as Yes
    And User validates for the attribute of 'Allow to Approve Age of Plumbing' selected as Yes
    And User validates for the attribute of 'ApproveElectricalUpdate' selected as Yes
    And User validates for the attribute of 'Homeowners - Approve Delete Sinkhole' selected as Yes
    And User validates for the attribute of 'Condo - Maximum Coverage A + C changed'
    And User validates for the attribute of 'Condo - Approve selected wind exclusion' selected as Yes
    And User validates for the attribute of 'Condo - Allowed to Approve Age of Systems' selected as Yes
    And User validates for the attribute of 'Dwelling - Maximum Condo Unit Owner Limit Change Allowed'
    And User validates for the attribute of 'Dwelling - Allowed to Approve Short Term Rental?' selected as Yes
    And User validates for the attribute of 'Allow to Approve Lease Term' selected as Yes
    And User validates for the attribute of 'Dwelling DP1 - Approve selected wind exclusion' selected as Yes
    And User validates for the attribute of 'Allow to Approve Change to Vandalism and Malicious Mischief' selected as Yes
    And User validates for the attribute of 'Dwelling - Maximum Coverage A Change DP1'
    And User validates for the attribute of 'Mobile Home - Maximum Coverage A Change'
    And User validates for the attribute of 'Personal Umbrella - Allowed to Approve New Business' selected as No
    And User validates for the attribute of 'FloodZoneOverride' selected as Yes
    And User validates for the attribute of 'Allow Plumbing Year Approval' selected as Yes
    And User validates for the attribute of 'Condo - Allowed to Approve Monthly Rental' selected as Yes
    And User validates for the attribute of 'Allow Application Take Ownership' selected as Yes
    And User validates for the attribute of 'Allow Override Lat Long Edit' selected as Yes
    And User validates for the attribute of 'Allow Quote Take Ownership' selected as Yes
    And User validates for the attribute of 'Allow Protection Class Override' selected as Yes
    And User validates for the attribute of 'Allow BCEG Override' selected as Yes
    And User validates for the attribute of 'Allow Edit ISO Location Fields' selected as Yes
    And User validates for the attribute of 'Allow Edit Year Built' selected as Yes
    And User validates for the attribute of 'TOApproveYOCChg' selected as Yes
    And User validates for the attribute of 'Maximum Forward Date Change'
    And User validates for the attribute of 'Allow Edit Dwelling Address' selected as Yes
    And User validates for the attribute of 'Allow Ordinance Or Law Change' selected as Yes
    And User validates for the attribute of 'Allow View Loss History Hidden Details' selected as Yes
    And User validates for the attribute of 'Allow to View and Edit Book Transfer field' selected as Yes
    And User validates for the attribute of 'HO6 ByPass Insurance Score Apply' selected as Yes
    And User validates for the attribute of 'Allow Coastal Zone Edit' selected as Yes
    And User validates for the attribute of 'Roles Able to Approve Capacity - All UW, Admin and Gold or Diamond Agents' selected as Yes
    And User clicks return button and validates User Maintenance screen displays
    And User clicks save
