# Introduction
This application demonstrates the use of JDBC in developing a connection between Java applications and RDBMS. This project involves the creation of Data Access Objects Patterns to perform CRUD(Create, Read, Update, and Delete) operations. Apache Maven was installed and used for defining all the dependencies. The tools used while developing this project are the PostgreSQL database management system, the Dbeaver tool for creating database scripts, the docker container to create an instance of PSQL, and IntelliJ IDE to develop the project.<br>

# Implementation
1. Start Docker container<br>
```
docker container start jrvs-psql
```
2. Connect to the PSQL instance <br>
```
psql -h localhost -U postgres -W
```
3. Create starter data i.e, database and tables by running following commands<br>
```
psql -h localhost -U postgres -f database.sql
psql -h localhost -U postgres -d hplussport -f customer.sql
psql -h localhost -U postgres -d hplussport -f product.sql
psql -h localhost -U postgres -d hplussport -f salesperson.sql
psql -h localhost -U postgres -d hplussport -f orders.sql
```
## ER Diagram

![ER.png](src%2Fmain%2Fresources%2Fassets%2FER.png)
## Design Patterns
<p>The Data Access Object (DAO) pattern is a structural pattern that allows us to isolate the application layer from the persistence layer (usually a relational database) using an abstract API. The API hides all the complexity of performing CRUD operations in the underlying storage mechanism from the application. It permits both layers to evolve separately without knowing anything about each other. In this project, I used the abstract Data Access Object Classes to perform all CRUD operations that contain implementation and retrieving data from the database, and then these DAO classes are extended by the customer and order classes to utilize this data.</p>
<p>The Repository pattern hides details of how data is persisted or retrieved from a database. The idea behind the Repository pattern is to perform operations (such as adding, updating, deleting, and selecting items from the collection)  through straightforward methods without dealing with database concerns such as connections and commands. Thus, it separates the data access layer from the business logic layer.</p>

# Test
The testing was started at the base level and done at various levels of development.
1. To ensure docker is running:<br>
  ```docker ps -f name=jrvs-psql```
2. Checking if the database was created using the following command<br>
```psql -h localhost -U postgres -d hplussport```
3. Used Queries to check if data has populated in the tables<br>
```SELECT COUNT(*) FROM customer;```
4. Run the java file to check if the JDBC connection is established<br>
5. Run and debug the java file after writing code for each CRUD operation.


