Feature: An employee will log in and update their email. Employee then will navigate to homepage then check that their info was updated.

Scenario: Non-manager logs in and updates their info. Then navigates to homepage and checks that the info was updated.
Given User navigates to ers website
And User enters correct username
And User enters correct password
And User clicks login
And User clicks view and update
And User inputs a new email address
And User clicks update
And User navigates to homepage
When User clicks view and update again
Then User confirms updated email