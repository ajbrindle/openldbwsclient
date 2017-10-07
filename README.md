Generates the sources from the OpenLWDWS API using JAX-WS.

Contains a class that executes a sample call to the getDepartureBoard service.  This will embed the token value in the SOAP header and then make the request.

To set token value, either edit ServiceCalls.java and replace YOUR_TOKEN_VALUE with the token value you have been provided with to use the API.  Or pass your token value as an argument when running the project.

Usage:

build: mvn clean compile

Run (from base directory): java -cp ./target/classes/ com.sk7software.openldbws.ServiceCalls [your-token-value]
