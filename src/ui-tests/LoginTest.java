package ui_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.get("https://github.com/login");
    }

    @Test
    public void loginWithValidCredentials() {
        WebElement username = driver.findElement(By.id("login_field"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.name("commit"));

        username.sendKeys("your_username");
        password.sendKeys("your_password");
        loginButton.click();

        // Verify user is logged in
        WebElement profileDropdown = driver.findElement(By.cssSelector(".Header-link"));
        Assert.assertTrue(profileDropdown.isDisplayed());
    }

    @Test
    public void testEmptyFields() {
        WebElement loginButton = driver.findElement(By.name("commit"));
        loginButton.click();

        WebElement error = driver.findElement(By.cssSelector(".flash-error"));
        Assert.assertTrue(error.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
