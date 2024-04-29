# Author: Mustafa Cemek
# created on 04/23/2024
#TEST CASE NUMBER & TITLE: JA-285-2024 Rate Change_FL_VOL HO6 Annual Filing
#Precondition: Create a HO6 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: As a Pricing analyst, I would like to implement the revised base rates for the FL VOL HO6 product effective 5/24/2024 for New Business and 7/21/2024 for Renewal Business so that the company's expectations are met.
#Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 5/24/2024 for New Business and 7/21/2024 for Renewals.
#Validate Base Rates for NHR & HUR premiums are correct.
#Validate Water Damage factors for excluded and limited rate correctly.
#Validate Base Rates / Water Damage & premiums display correctly for each Peril on the Worksheet UI.
#Validate Base Rate / Water Damage premiums are correct and display correctly on Dwelling, Review, & Premium Info pages.
#Validate Base Rates / Water Damage factors do not change on endorsement including out of sequence endorsements.
#Validate Base Rate / Water Damage factor changes when change date transaction crosses the New Business Effective date.
#Validate the revised Base Rates / Water Damage premiums are showing on all the declaration pages correctly.
#Validate Base Rates / Water Damage factors do not change on reinstatement transactions.
#EXPECTED RESULTS: UW referral should be displayed by Agant
#User: Standard Agent, Underwriter
@HO6RateChange2024
Feature: MTR6082_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes in 5/24/2024 for New Business

  @mtr6082
  Scenario Outline: MTR6082_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 5/24/2024 for New Business. With Water Damage Exclusion
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6082>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User clicks Water Damage Exclusion
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6082>
    Then User verifies HO6 Hurricane Base Rate <mtr6082>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6082>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in New Business Package <mtr6082>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress   | DwellingZip | EffectiveDate | State   |
      | 1163 Oak Bluff Dr |       33837 | 05/24/2024    | Florida |

  @mtr6083
  Scenario Outline: MTR6083_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 06/26/2024 for New Business. With Water Damage Exclusion and Water Damage Limited
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6083>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User clicks Water Damage Exclusion
    And User clicks Water Damage Limited
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6083>
    Then User verifies HO6 Hurricane Base Rate <mtr6083>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6082>
    Then User verifies HO6 Water Damage Limited Factor <mtr6083>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in New Business Package <mtr6082>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress     | DwellingZip | EffectiveDate | State   |
      | 4108 Via Sienna Cir |       34243 | 06/26/2024    | Florida |

  @mtr6084
  Scenario Outline: MTR6084_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 05/23/2024 for New Business.
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    #And User Searchs Policy
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6084>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6084>
    Then User verifies HO6 Hurricane Base Rate <mtr6084>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in New Business Package <mtr6082>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress   | DwellingZip | EffectiveDate | State   |
      | 1163 Oak Bluff Dr |       33837 | 05/23/2024    | Florida |

  @mtr6085
  Scenario Outline: MTR6085_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 07/21/2024 for Renewal.
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6085>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User clicks Water Damage Exclusion
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    Then User verifies RN HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6085>
    Then User verifies HO6 Hurricane Base Rate <mtr6085>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6085>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in Renewal Declaration Package <mtr6085>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress | DwellingZip | EffectiveDate | State   |
      | 2141 Penny Ln   |       34741 | 07/21/2023    | Florida |

  @mtr6086
  Scenario Outline: MTR6086_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 07/20/2024 for Renewal.
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6086>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    Then User verifies RN HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6086>
    Then User verifies HO6 Hurricane Base Rate <mtr6086>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in Renewal Declaration Package <mtr6085>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress       | DwellingZip | EffectiveDate | State   |
      | 7664 Buffalo Ridge Rd |       32571 | 07/20/2023    | Florida |

  @mtr6087
  Scenario Outline: MTR6087_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 08/21/2024 for Renewal. With Water Damage Exclusion and Water Damage Limited
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6087>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User clicks Water Damage Exclusion
    And User clicks Water Damage Limited
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    Then User verifies RN HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6087>
    Then User verifies HO6 Hurricane Base Rate <mtr6087>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6082>
    Then User verifies HO6 Water Damage Limited Factor <mtr6083>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in Renewal Declaration Package <mtr6085>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress    | DwellingZip | EffectiveDate | State   |
      | 75928 SAFFRON Lane |       32097 | 08/21/2023    | Florida |

  @mtr6088
  Scenario Outline: MTR6088_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 05/24/2024 for Cancellation and Reinstatement
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6082>
    And User enters all required information on HO6 dwelling screen <mtr6088>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr154>
    And User selects Property Sold as reason <mtr154>
    And User sets the effective date as 05.24.2024
    And User validates Policy Status displayed as Cancelled <mtr6088>
    And User clicks Start Transaction
    And User selects Reinstatement and validates <mtr219>
    And User clicks Term-Seq Number
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6088>
    Then User verifies HO6 Hurricane Base Rate <mtr6088>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in New Business Package <mtr6082>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress   | DwellingZip | EffectiveDate | State   |
      | 1163 Oak Bluff Dr |       33837 | 05/24/2024    | Florida |

  @mtr6089
  Scenario Outline: MTR6089_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 5/23/2024 for New Business. With Water Damage Exclusion. Change Date > Eff Date (05/24/2024)
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6082>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User clicks Water Damage Exclusion
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Start Transaction
    And User clicks Change Date Transaction Selection
    And User enters 05.24.2024 as new effective date <mtr6089>
    And User clicks Process
    Then User verifies Changed Date <mtr6089>
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6089>
    Then User verifies HO6 Hurricane Base Rate <mtr6089>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6082>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in New Business Package <mtr6082>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress  | DwellingZip | EffectiveDate | State   |
      | 1814 Blue Orchid |       33565 | 05/23/2024    | Florida |

  @mtr6090
  Scenario Outline: MTR6090_HO6_Validate the Base Rates for NHR & HUR and Water Damage factor changes are effective 5/23/2024 for New Business. With Water Damage Exclusion. Change Date > Eff Date (05/24/2024)
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6082>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User clicks Water Damage Exclusion
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    Then User verifies EN HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6090>
    Then User verifies HO6 Hurricane Base Rate <mtr6090>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6082>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in Endorsement Package <mtr6090>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress  | DwellingZip | EffectiveDate | State   | EndorsementEffectiveDate |
      | 15932 SW 13th St |       34481 | 05/24/2024    | Florida | 06/10/2024               |

  @mtr6091 @ja
  Scenario Outline: JA 285 - MTR6082-VOL HO6 New Rating to the regression suit. Effective 5/24/2024, NB. Change Date, 5/23/2024. RN Transaction, 5/23/2025 and EN 5/24/2025
    Given User navigates to QA7
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr6082>
    And User enters HO6 Dwelling Address "<DwellingAddress>"
    And User enters HO6 Dwelling Zip "<DwellingZip>"
    And User enters effective date "<EffectiveDate>"
    And User enters state "<State>"
    And User selects product on Product Selection List
    And User enters all required information on HO6 quote screen <mtr6084>
    And User enters all required information on HO6 dwelling screen <mtr6082>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User clicks Water Damage Exclusion
    And User clicks Water Damage Limited
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6082>
    Then User verifies HO6 Hurricane Base Rate <mtr6082>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6082>
    Then User verifies HO6 Water Damage Limited Factor <mtr6083>
    And User clicks HO6 Policy File Chevron
    Then User verifies Revised Base rate Premiums display in New Business Package <mtr6082>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks Change Date Transaction Selection
    And User enters 05.23.2024 as new effective date <mtr6089>
    And User clicks Process
    Then User verifies Changed Date <mtr6089>
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6084>
    Then User verifies HO6 Hurricane Base Rate <mtr6084>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    Then User verifies RN HO6 policy has been created successfully
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6082>
    Then User verifies HO6 Hurricane Base Rate <mtr6082>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6082>
    Then User verifies HO6 Water Damage Limited Factor <mtr6083>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    Then User verifies EN HO6 policy has been created successfully <mtr6082>
    And User clicks Worksheets chevron
    Then User verifies HO6 Non-Hurricane Base Rate <mtr6082>
    Then User verifies HO6 Hurricane Base Rate <mtr6082>
    Then User verifies HO6 Water Damage Excluded Factor <mtr6082>
    Then User verifies HO6 Water Damage Limited Factor <mtr6083>
    And User clicks Dwelling chevron
    Then User verifies HO6 Coverage Premiums in Coverage List <mtr6082>
    And User clicks Review Chevron
    Then User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>
    And User clicks Premium Info Chevron
    Then User verifies HO6 Coverage Premiums in Premium Information <mtr6082>

    Examples: Test Data
      | DwellingAddress   | DwellingZip | EffectiveDate | State   | EndorsementEffectiveDate |
      | 1163 Oak Bluff Dr |       33837 | 05/24/2024    | Florida | 05/24/2025               |
