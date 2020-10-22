Feature: Google Page Test

Scenario: Check Elements in Home Page
Given I launch the Chrome Browser
When I open google page
Then It displays the search bar
And I validate the search bar
Then I close the browser

Scenario: Validate Search Text
Given I launch the Chrome Browser
When I open google page
Then It displays the search bar
And I validate the search result
Then I close the browser