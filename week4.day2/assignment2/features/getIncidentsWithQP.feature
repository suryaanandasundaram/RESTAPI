Feature: ServiceNow Incident Management

@Smoke
Scenario: Get all the Incidents

Given set the endpoint

And add the authentication

And add the queryParam "sysparm_fields" as "sys_id"

When send the request with QP

Then validate the response

