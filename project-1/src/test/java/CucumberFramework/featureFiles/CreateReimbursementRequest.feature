Feature: Non-manager can create a reimbursement request

Scenario: Employee logs into their account and creates and submits a reimbursement request. Then checks if the request is pending.
Given User navigates to ers website
And User enters correct username
And User enters correct password
And User clicks login
And User2 clicks submit new request
And User2 enters request amount
And User2 enters reason
And User2 clicks other radio button
And User2 clicks submit for the request
And User2 navigates to homepage
When User2 clicks pending requests
Then User2 sees new pending request