# Full-Stack Login System with Selenium Automation

This project demonstrates a complete software quality lifecycle. It includes a backend API, a frontend UI, and a dedicated Selenium automation suite to test the application end-to-end.

## Project Structure

*   `backend/`: Spring Boot REST API (Java 17, PostgreSQL). Handles user registration and login logic.
*   `login-ui/`: React Frontend. A simple interface for users to sign up and sign in.
*   `automation-tests/`: Java Selenium project. An automated robot that launches a browser and verifies the registration and login flows work correctly.

## Technologies
*   Java & Spring Boot
*   React & Axios
*   Selenium WebDriver & Java
*   PostgreSQL

## How to Run

1.  **Backend:** Configure Postgres in `backend/src/main/resources/application.properties` and run the Spring Boot app.
2.  **Frontend:** Navigate to `login-ui`, run `npm install` and `npm start`.
3.  **Automation:** With both apps running, navigate to `automation-tests` and run the `LoginBot.java` file to see the automated testing in action.