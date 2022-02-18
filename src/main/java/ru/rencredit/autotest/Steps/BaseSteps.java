package ru.rencredit.autotest.Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.rencredit.autotest.Utils.TestProperies;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected Properties properties = TestProperies.getInstance().getProperties();
    protected static WebDriver driver;

    @Before
    public void setUp() {
        switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "explorer":
                System.setProperty("webdriver.ie.driver", properties.getProperty("webdriver.ie.driver"));
                driver = new InternetExplorerDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }
        driver.get(properties.getProperty("app.url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @After
    public void clouseWindow() {
       driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }



}