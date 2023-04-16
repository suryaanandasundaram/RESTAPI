Feature: ServiceNow Incident Management 

Scenario: Get all the Incidents - Description and category printed for those category is hardware

Given set the endpoint

And add the authentication

And add the queryParams 
|sysparm_fields|description,category|
|category|hardware|

When send the request with QP

Then validate the response


