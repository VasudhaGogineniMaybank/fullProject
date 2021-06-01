Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forget Password Link
Given user is on login page
Then forget your password link should be displayed

Scenario: Signin with correct credentials 
Given user is on login page
When user enters username "testjenkins123456@gmail.com"
And user enters password "Testing@123456"
And user clicks on Sign in button
Then user gets the title of the page
And page title should be "My account - My Store" 