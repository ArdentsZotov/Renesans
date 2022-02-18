package ru.rencredit.autotest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rencredit.autotest.Steps.BaseSteps;

public class HomePage extends BasicPage {
    private WebDriver driver;

    @FindBy (className = "main-screen__title")
    WebElement titlelement;

    @FindBy (xpath = "//div[text()='Вклады']/..")
    WebElement vkladElem;



    public HomePage() {
        this.driver=BaseSteps.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void clickVkladElem() {
       new WebDriverWait(driver,5,1000).
        until(ExpectedConditions.elementToBeClickable(vkladElem));
        vkladElem.click();
    }
}
