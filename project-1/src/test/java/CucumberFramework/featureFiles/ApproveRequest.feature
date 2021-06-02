Feature: Manager will view current requests, then approve and deny one. Manager will then navigate to homepage a view past requests

Background: 
Given User navigates to ers website
And Manager enters correct username
And Manager enters correct password
And User clicks login
And Manager is taken to correct Manager homepage 
And Manager2 clicks review requests

Scenario: Manager logs into their account and approves a request. The manager then views the resolved requests
And Manager2 clicks approve
And Manager2 navigates to homepage
When Manager2 clicks resolved requests
Then Manager2 views resolved requests 

Scenario: Manager logs into their account and denies a request. The manager then views the resolved requests
And Manager2 clicks deny
And Manager2 navigates to homepage
When Manager2 clicks resolved requests
Then Manager2 views resolved requests
