#Author: Can Yavas
#created on 09/27/2023

@agentprofilesetup
Feature: Agent Profile Setup

  Scenario: Validate Agent Profiles Successfully have been added to desired environment
    Given User login to Spin as Admin Agent
		Then User creates Agent Profiles with passing information from excel "Agent" sheet