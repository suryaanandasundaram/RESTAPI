Feature: ServiceNow Incident Management

@Smoke @Sanity
Scenario: Get all the Incidents

Given set the endpoint

And add the authentication

And add the queryParams 
|sysparm_fields|sys_id,category|
|category|software|

When send the request with QP

Then validate the response

