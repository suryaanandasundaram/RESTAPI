Feature: ServiceNow Incidents Creation -DataTable


Scenario: Create Incident with Data Table

And add "This is Test" and "software"

When send the request for create

Then validate the response of create Incident fields
|result.urgency|3|
|result.approval|not requested|
|result.knowledge|false|
|result.number|INC|