Feature: ServiceNow Incident Creation

Scenario: Create Incident using file

Given set the endpoint

And add the authentication

When pass the file and send the request
|./src/test/resources/CreateIncident.json|
|./src/test/resources/CreateIncident.json|
|./src/test/resources/CreateIncident.json|


Then validate the response of create






