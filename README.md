# Clarity Software Group Technical Skills Test

This application allows for the storage, retrieval and updating of metric data

## Running the application

* Clone the project from the GitHub URL: https://github.com/itsNeoXu/clarity-tech-test
* Navigate to the cloned directory
* Run ./mvnw spring-boot:run (Unix) or mvnw.cmd spring-boot:run (Windows)

## APIs and example usage

GET /metrics
* curl "localhost:8080/metrics?system=system_1&name=system_1_metric_1&from=1684342263&to=1684342265"

GET /metrics/{id}
* curl "localhost:8080/metrics/1"

POST /metrics
* curl -X POST "localhost:8080/metrics"
  -H 'Content-Type: application/json'
  -d '{"system":"system_5","name":"system_5_metric_4","date":1684342272,"value":54321}'

PUT /metrics/{id}
*  curl -X PUT "localhost:8080/metrics/1"
  -H 'Content-Type: application/json'
  -d '{"id":1,"system":"system_1","name":"system_1_metric_1","date":1684342263,"value":1234567}'

GET /metricsummary
* curl "localhost:8080/metricsummary?system=system_1&name=system_1_metric_1&from=1684342263&to=1684342265"