# Moneytransfer

Requirement - 
JDK 7 or above. Maven.

Start the application:

mvn exec:java

To test out the application:-

This is the process to Test out this application:
curl -X POST -H "Content-Type: application/json" -d '{ "amount": "1000","sender_name": "Suman Dutta", "sender_bank_name":"BOFA","sender_acc_num": "10010011"}' 
http://localhost:8080/rest/moneytransfer

Example:
curl -X POST -H "Content-Type: application/json" -d '{ "amount": "1000","sender_name": "Suman Dutta", "sender_bank_name":"BOFA","sender_acc_num": "10010011","sender_routing_num": "1000001", "sender_address":"Sunnyvale, CA", "sender_phone":"6692261111","recipient_name":"Albert Pinto","recipient_bank_name":"Chase","recipient_bank_address":"Huston,TX", "recipient_bank_acc_num":"444999000","recipient_bank_routing_num":"300003", "recipient_phone_numb":"8179993333"}' 
http://localhost:8080/rest/moneytransfer

Response:
{'response':'Success', 'uuid': 'Sum15072019162518','code':'0'}


GET:
http://localhost:8080/rest/moneytransfer/{transactionId}

Example:
http://localhost:8080/rest/moneytransfer/Sum15072019162518
Response :
{'response':'Transaction Completed','code':'0'}

Gateway PUT:
curl -X PUT http://localhost:8080/rest/paymentgateway/updatetransfer/{transactionId}/{status}
status : 00 for Update complete

Example:
curl -X PUT http://localhost:8080/rest/paymentgateway/updatetransfer/Sum15072019162518/00
Response:
{'response':'Failed to Update','code':'98'}
or
{'response':'Status Updated','code':'0'}
