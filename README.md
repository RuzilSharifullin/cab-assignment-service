Initially all cabs are assigned. I exposed an endpoint, GET localhost:9080/api/v1/event/cablocations, which produces cab_location events in multiple asynchronous threads.

Added swagger ui for your convenience http://localhost:9080/swagger-ui.html

There's also an integration test which covers all the functionality. Unfortunately didn't have enough time to make it running after starting the basic docker compose file