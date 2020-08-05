# DWP Tech test --Smita Jain

### Solution
The solution I have developed is a small SpringBoot Gradle Java Webapp. 
It offers 1 rest endpoint for now as I've not worked on the frontend and it just displays the results unformatted in the browser.

The endpoint return a JSON list of the relevant users who are 60 miles from London.

To return all users within 60 miles of London:

GET http://localhost:8080/get-users-within-sixty-miles-of-london
