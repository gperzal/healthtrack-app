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
        ChromeOptions options = new ChromeOptions();
        // Use Chromium binary on GitHub Actions
        options.setBinary(System.getenv("CHROME_BIN"));
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");

        // Set explicit path to chromedriver on Linux
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        driver = new ChromeDriver(options);
    }


    @Test
    public void testOpenExamplePage() {
        // Page load timeout para que no cuelgue CI
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // Navegar a example.org, que siempre tiene el título "Example Domain"
        driver.get("https://example.org");
        String pageTitle = driver.getTitle();

        // Validaciones claras
        assertNotNull(pageTitle, "Page title should not be null");
        assertEquals("Example Domain", pageTitle, "Page title should match 'Example Domain'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
