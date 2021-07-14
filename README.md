Initially all cabs are assigned. I exposed an endpoint, GET localhost:9080/api/v1/event/cablocations,
which produces cab_location events in multiple asynchronous threads. 

Added swagger ui for convenience
http://localhost:9080/swagger-ui.html

There's also an integration test which covers all functionality.
Unfortunately, didn't have enough time to automate it with the help of another 
docker compose file