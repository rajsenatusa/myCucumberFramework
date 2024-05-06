#Author: Can Yavas
#created on 09/27/2023


Feature: Agent Profile Setup
  
  @agentprofilesetup
  Scenario: Validate Agent Profiles Successfully have been added to desired environment
    Given User login to Spin as Admin Agent
		Then User creates Agent Profiles with passing information from excel "UserManagement" sheet
		
		
	@agentonboardingsetup
  Scenario: Validate Agent Onboarding Successfully have been added to desired environment
    Given User login to Spin as Admin Agent
		Then User adds Agent Onboarding details with passing information from excel "UnderwritingMaintenance" sheet
		
	
	@commisionupdate	
	Scenario: Validate Agent Commission Rates for selected producers from excel list have been updated in desired environment
    Given User login to Spin as Admin Agent
		Then User edits Agent Commissions with passing information from excel "ProducerCode" sheet