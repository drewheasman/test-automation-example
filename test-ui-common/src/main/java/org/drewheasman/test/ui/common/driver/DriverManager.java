package org.drewheasman.test.ui.common.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.drewheasman.test.ui.common.page.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;

public class DriverManager {
    private WebDriver driver;

    public DriverManager(DriverType driverType) {
        PageLoadStrategy pageLoadStrategy = PageLoadStrategy.EAGER;
        Dimension windowSize = new Dimension(1366, 768);

        switch (driverType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                chromeOptions.setPageLoadStrategy(pageLoadStrategy);

                driver = new ChromeDriver(chromeOptions);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=new");
                firefoxOptions.setPageLoadStrategy(pageLoadStrategy);

                driver = new FirefoxDriver(firefoxOptions);
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                edgeOptions.setPageLoadStrategy(pageLoadStrategy);

                driver = new EdgeDriver();
            }
            case SAFARI -> {
                WebDriverManager.safaridriver().setup();

                SafariOptions safariOptions = new SafariOptions();
                // Headless is not available, you need real macOS to run
                safariOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

                driver = new SafariDriver(safariOptions);
            }
        }

        changeWindowSize(windowSize);
    }

    private void changeWindowSize(Dimension windowSize) {
        driver.manage().window().setSize(windowSize);
    }

    public void loadUrl(URL url) {
        driver.navigate().to(url);
    }

    public void initialiseElements(BasePage basePage) {
        PageFactory.initElements(driver, basePage);
    }

    public void quit() {
        driver.quit();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
