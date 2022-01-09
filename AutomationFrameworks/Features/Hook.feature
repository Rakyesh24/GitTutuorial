Feature: Hook test
@smoke1
Scenario: Rediff login with invalid credentails

Given Rediffmail application is opened
When user try to login with invalid credentails
Then validate the result of rediffmail


@smoke2
Scenario: Bhane login with valid credentails

Given Login application is opened
When user try to login with valid credentails
Then validate the result of Bhane







 