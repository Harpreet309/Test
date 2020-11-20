Feature: Hotel Booking Application

Scenario Outline: Validate Hotel Booking Flow
Given User is on login page and verify page heading
And Validate Error messages by clicking on Login Button if Username and Password is not given
Then User should navigate to Hotel Booking Page and Validates Page Title
When User select confirm booking without entering the First Name<First_Name> then Validates the alert box with message   
When User select confirm booking without entering the Last Name<Last_Name> then Validates the alert box with message 
And Validate Email format in alert box by giving invalid email format  
When User select confirm booking without entering contact number<Contact_Number> then validates the alert box with message
And Validate whether Correct Format of contact number<Contact_Number> is enetered or not
Then Enter the Address details and it should not be empty
And Validate the alert box with message if city<City> is not selected
And Validate the alert box with message if state<State> is not selected
And Validate Rooms and Number of guests<Guest_Number> 
Then Enter Card Holder name<Name> and Validate the alert box if Card Holder Name is not entered
Then Enter Debit Card Number Holder<Card_Number> and Validate the alert box if Card Number is not entered
Then Enter CVV Number<CVV> and Validate the alert box if CVV is not entered
Then Enter Card Expiration Month<Month> and Validate the alert box if Expiration Month is not entered
And Enter Card Expiration Year<Year> and Validate the alert box if Expiration Year is not entered
Then Click on confirm booking after filling the form
And Validate Booking confirmed message
Examples:
|First_Name|Last_Name|Contact_Number|City|State|Name|Card_Number|Month|Year|Guest_Number|CVV|
|Harpreet|Singh|7814959595|Pune|Maharashtra|Harpreet Singh|7412589634|11|2022|3|194|




  

