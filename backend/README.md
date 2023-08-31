# Technology Stack

- Java EE (Jakarta EE)
- OpenAPI3
- Maven

# Steps to run locally

- Set all the properties that are required:
    - DBCONNECTIONSTRING: MongoDB connection string.
    - DBNAME: name of the database.
    - JWTSECRETKEY: secret key to sign the JWT tokens.
    - ADMINUSERNAME: username for sub claim in JWT token for admins.
- Execute following command: `mvn -DDBCONNECTIONSTRING="<db connection string>" -DDBNAME="<db name>" -DJWTSECRETKEY="<jwt secret key>" -DADMINUSERNAME="<jwt sub claim for admin>" clean package jetty:run`.

> **NOTE**: OpenAPI3 specification document available at `http://localhost:9999/health-connect-plus/swagger.json`