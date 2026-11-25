Expense Tracker
===============

A Spring Boot application for tracking expenses with a fixed set of categories.

Current status
--------------
The project provides REST endpoints for expenses and uses a fixed set of
expense categories. PostgreSQL stores the data.

Run with Docker
---------------
Requirements: Docker Desktop (or Docker Engine with the Compose plugin).

1. Copy `.env.example` to `.env` and change `DB_PASSWORD` if you want a
   different local database password.
2. Start the app and database:

     docker compose up --build

3. Open http://localhost:8080/ or call the API. For example, list expenses:

     curl http://localhost:8080/expenses

The PostgreSQL database is stored in a named Docker volume and survives
container restarts. Stop the containers with Ctrl+C, or run
`docker compose down`. To also delete the local database data, run
`docker compose down -v`.

Local development without Docker
---------------------------------
Install Java 26 and PostgreSQL, then set `DB_URL`, `DB_USER`, and `DB_PASSWORD`
as environment variables if your local database uses different settings.

Run locally
-----------
macOS/Linux:
  ./mvnw spring-boot:run

Windows:
  mvnw.cmd spring-boot:run

Then open http://localhost:8080/ in your browser.

Test
----
  ./mvnw test

Planned features
----------------
- Create, view, update, and delete expenses
- Filter expenses by category
- Track totals and spending history
