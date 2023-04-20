Feature: ServiceNow Incidents Creation




#Given set the endpoint

#And add the authentication

Scenario: Create Incident

And add "This is Test" and "software"

When send the request for create

Then validate the response of create Incident

Scenario: Update Incident

And update RandomString as description

When send the request for update

Then validate the response of update Incident

Scenario: Delete Incident

When send the request for delete

Then validate the response of delete Incident

And validate the record is removed