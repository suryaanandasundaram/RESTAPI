Feature: Create Incident with Validations

Scenario Outline: Create Incident

Given set the endpoint

And add the authentication

And add "<short_desc>" and "<category>"

When send the request

Then validate the response of createIncident

Examples:
|short_desc|category|
|This is First|software|

