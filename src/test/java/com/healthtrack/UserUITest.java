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

        // Read binary from CHROME_BIN (set in CI), fallback to chromium-browser
        String chromeBinary = System.getenv("CHROME_BIN");
        if (chromeBinary == null || chromeBinary.isEmpty()) {
            chromeBinary = "/usr/bin/chromium-browser";
        }
        options.setBinary(chromeBinary);

        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testOpenExamplePage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://example.org");
        String pageTitle = driver.getTitle();
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
