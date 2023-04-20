Feature: ServiceNow Incidents Creation

Scenario Outline: Create 3 Different Incidents

Given set the endpoint

And add the authentication

And add "<short_desc>" and "<category>"

When send the request

Then validate the response


Examples:
|short_desc|category|
|This is First|software|
|This is Second|hardware|
|This is Third|inquiry|