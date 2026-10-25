package com.juaracoding.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Path;
import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless=new",
                "--disable-gpu",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--window-size=1366,900"
        );

        String configuredBinary = System.getProperty(
                "chrome.binary",
                System.getenv("CHROME_BINARY")
        );
        if (configuredBinary != null && !configuredBinary.isBlank()) {
            options.setBinary(configuredBinary);
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    protected void openPracticePage() {
        Path page = Path.of("src", "main", "resources", "webapp", "locator_practice.html")
                .toAbsolutePath()
                .normalize();
        driver.get(page.toUri().toString());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
