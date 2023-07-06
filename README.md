# spring-boot-jpa-example
Sample CRUD app with Spring Boot + Spring JPA + Postgres.

# Getting Started

1. Clone the repo.
2. Download and install Postgres locally.
3. Create a database titled `cars` (see command below).
4. Build the project with the following command:
```bash
mvn clean install
```
5. Run the app with the following command:
```bash
mvn spring-boot:run -Dspring.profiles.active=local
```
6. Hit the API via CURL or a REST client like Postman.

# API

1. Get all cars

```bash
curl -X GET localhost:8080/api/v1/cars
```

2. Create a new car

```bash
curl --location 'localhost:8080/api/v1/cars' \
--header 'Content-Type: application/json' \
--data '{
    "make": "tesla",
    "model": "model 3"
}'
```

3. Get car with a specific `id`:

```bash
curl --location --request GET 'localhost:8080/api/v1/cars/1'
```

4. Delete car with a specific `id`:

```bash
curl --location --request DELETE 'localhost:8080/api/v1/cars/1'
```

# Postgres Queries

1. _List All Tables_

```sql
SELECT * FROM pg_catalog.pg_tables where schemaname='public';
```

2. _Create database_

```sql
create database cars;
```

3. _List all cars_

```sql
select * from cars; -- cars the table, not the database
```
