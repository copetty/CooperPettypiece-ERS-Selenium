Feature: Employee can login with correct credentials

Background: 
Given User navigates to ers website

Scenario: Login into non-manager account with correct credentials
And User enters correct username
And User enters correct password
When User clicks login
Then User is taken to correct employee homepage

Scenario: Login to non-manager account with incorrect credentials
And User enters correct username
And User enters incorrect password
When User clicks login
Then User should see a message saying incorrect username or password 

Scenario: Login to manager account with correct credentials
And Manager enters correct username
And Manager enters correct password
When User clicks login
Then Manager is taken to correct Manager homepage 

Scenario: Login to manage with incorrect password
And Manager enters correct username
And Manager enters incorrect password
When User clicks login
Then User should see a message saying incorrect username or password

Scenario: Login to employee account and then logout
And User enters correct username
And User enters correct password
And User clicks login
When User clicks logout
Then User is taken to login screen 





