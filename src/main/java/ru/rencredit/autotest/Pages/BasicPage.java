package ru.rencredit.autotest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.rencredit.autotest.Steps.BaseSteps;

public class BasicPage {
    protected WebDriver driver;

    public BasicPage() {
        this.driver= BaseSteps.getDriver();
        PageFactory.initElements(driver,this);
    }

    public String getDriverTitl() {
        return driver.getTitle();
    }

}
