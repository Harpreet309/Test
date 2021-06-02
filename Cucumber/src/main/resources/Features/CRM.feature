Feature: CRM Application

Scenario: Create Task in CRM Application
Given User Navigate to the URL and Login to the Application
|Username||Password|
|singh.harpreet309kss@gmail.com||Amritsar|
And Validate whether user ia ta home page or not
Then Navigate to Create Task option and select it
When Validate whether user is at Create Task Page or not
Then Fill Required fields in Create Task page
|Title|Deal|Description|Contact|Case|Completion|
|Doctor|Cars|Deal Accepted|7814949589|Full Time|90|
|Engineer|Trucks|Deal Rejected|9958857899|Exempted|88|
|CA|Money|Partial Accepted|4587956666|Rejected|100|
Then Close the browser
