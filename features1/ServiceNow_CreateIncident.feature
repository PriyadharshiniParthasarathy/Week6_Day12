Feature: Service_Now
@sanity
Scenario Outline: Create_Incident

Given Enter the URL as <url>
Given Enter the UserName in Servicenow as <username>
Given Enter the Password in Servicenow as <password>
When Click on the Login bttn
Given Click on the All button as <filter>
When Click on the New button
Given Enter a value for Caller as <Caller_name>
Given Enter value for short_description as <short_description>
Then Read the incident number and save it a variable
When Click on Submit button


Examples:
|url|username|password|filter|Caller_name|short_description|
|'https://dev94415.service-now.com'|'admin'|'HrvPD2fgSfL5'|'incident'|'Sam Sorokin'|'Incident - Short_description'|
