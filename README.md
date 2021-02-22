# digi-pharma
Digital Pharma Platform
Digi Pharma is a distributed digital Pharmacy platform which manages the end to end flow from accepting a doctor’s prescription to disbursement of the order. System is developed according to the Micro Service design principles. System is loosely coupled and tightly cohesive. All the back end services are well documents Restful APIs.

Services:
User-service
Order-service
Delivery-service
Notification-service
Registry-service
Auth-service / API gateway

 Deploying Application
Download the code from below GitHub location
https://github.com/manodya/digi-pharma.git

Build the code and create the docker images (Docker should up and running or skip the test cases till next version)
 mvn package  / mvn package -DskipTests      

Deploy the containers using below command
docker-compose -f docker-compose.yml up
