Json's:
SERVER
{
"load": 0.0,
"maxLoad": 100.0,
"energyConsumption": 0.0
}

REQUEST
{
"load": 0.0
}

Endpoints:

POST
http://localhost:8080/servers/
add new server 

DELETE
http://localhost:8080/servers/
remove server 

GET
http://localhost:8080/servers/energy
get total energy consumption

POST
http://localhost:8080/servers/resources
add load on server

DELETE
http://localhost:8080/servers/resources
release resources from server