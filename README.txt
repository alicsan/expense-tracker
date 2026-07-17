Expense Tracker
===============

A Spring Boot application for tracking expenses and organizing them by category.

Current status
--------------
The project is in its initial setup phase. It includes the application bootstrap,
expense and category domain models, PostgreSQL configuration, and a simple home
endpoint.

Requirements
------------
- Java 26
- PostgreSQL

Configuration
-------------
Create a PostgreSQL database named `expense_tracker` and update the datasource
settings in `src/main/resources/application.properties` with your local database
URL, username, and password.

Run locally
-----------
macOS/Linux:
  ./mvnw spring-boot:run

Windows:
  mvnw.cmd spring-boot:run

Then open http://localhost:8080/ in your browser. The current endpoint responds
with `Welcome home`.

Test
----
  ./mvnw test

Planned features
----------------
- Create, view, update, and delete expenses
- Organize expenses into categories
- Track totals and spending history
