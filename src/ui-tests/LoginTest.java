package ui_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize the browser
        WebDriver driver = new ChromeDriver();

        // Navigate to GitHub login page
        driver.get("https://github.com/login");

        // Locate and fill in the username and password fields
        WebElement username = driver.findElement(By.id("login_field"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("your-username");
        password.sendKeys("your-password");

        // Click the sign-in button
        WebElement loginButton = driver.findElement(By.name("commit"));
        loginButton.click();

        // Add assertions to verify login success (e.g., by checking the page URL)
        if (driver.getCurrentUrl().contains("github.com")) {
            System.out.println("Login Test Passed!");
        } else {
            System.out.println("Login Test Failed!");
        }

        // Close the browser
        driver.quit();
    }
}

