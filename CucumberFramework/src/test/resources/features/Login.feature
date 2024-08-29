Feature: Login functionality

Scenario: Login with valid credentials
Given User has navigated to login page
When User enters valid email address "amotooricap0009@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in

Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address "amotoori241220922@gmail.com" into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enters valid email address "amotooricap0009@gmail.com" into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User enters invalid email address "amotoori2471222@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User has navigated to login page
When User does not enter email address into email field
And User does not enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch