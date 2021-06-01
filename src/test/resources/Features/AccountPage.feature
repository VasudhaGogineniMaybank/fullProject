Feature: Account Page feature

Background:
Given user has already logged in to the application
|username|password|
|testjenkins123456@gmail.com|Testing@123456|

Scenario: Account page title
Given user is on accounts page
When user gets the title of the page
Then page title should be "My account"

Scenario: Accounts section count
Given user is on accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6
