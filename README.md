 QA Automation Assignment

 Project Setup

 Prerequisites
- Install Java (JDK 11 or higher)
- Install Maven
- Install ChromeDriver (for Selenium)
- Install any IDE (e.g., IntelliJ, Eclipse)

Steps to Run UI Tests
1. Clone the repository.
2. Navigate to the project directory.
3. Run the following command to execute the tests:
   ```bash
   mvn test
   ```
 Steps to Run API Tests
1. Ensure you have a valid GitHub token.
2. Replace the placeholder in the `RepositoryApiTest.java` file with your token.
3. Run the API tests using:
   ```bash
   mvn test
   ```

 Running Tests with GitHub Actions
The repository is configured to run tests automatically with GitHub Actions on each commit. 
