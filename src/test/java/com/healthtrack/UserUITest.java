package com.healthtrack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class UserUITest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set Chrome to headless mode and define binary path for CI
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome"); // Chrome pre-installed on GitHub Actions
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testOpenExamplePage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://httpbin.org/get");
        String pageTitle = driver.getTitle();
        assertNotNull(pageTitle, "Page title should not be null");
        assertFalse(pageTitle.isEmpty(), "Page title should not be empty");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
