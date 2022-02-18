package ru.rencredit.autotest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rencredit.autotest.Steps.BaseSteps;

public class DepositPage extends BasicPage {

    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    @FindBy (xpath = "//*[text()='Рассчитайте доходность по вкладу']")
    WebElement titl;

    @FindBy (name = "amount")
    WebElement summDeposit;

    @FindBy (xpath = "//div[@class='jq-selectbox__select-text']")
    WebElement selectTimeDeposit;

    @FindBy (name = "replenish")
    WebElement everyMounthDeposit;

    @FindBy (xpath = "//span[text()='Ежемесячная капитализация']/.." +
            "/..//div[contains(@class,'jq-checkbox calculator__check')]")
    WebElement checkBoxEvrMonCapit;

    @FindBy (xpath = "//span[text()='Частичное снятие']/.." +
            "/..//div[contains(@class,'jq-checkbox calculator__check')]")
    WebElement partWindwal;

    @FindBy (xpath = "//span[@class='js-calc-rate']")
    WebElement Stavka;

    @FindBy (xpath = "//span[@class='js-calc-result']")
    WebElement KSnytiu;

    @FindBy (xpath = "//span[@class='js-calc-replenish']")
    WebElement popolnenie;

    @FindBy (xpath = "//span[@class='js-calc-earned']")
    WebElement nachisleno;

    public DepositPage() {
        this.driver= BaseSteps.getDriver();
        PageFactory.initElements(driver,this);
        new WebDriverWait(driver,5,1000).
                until(ExpectedConditions.visibilityOf(titl));
    }

    @Override
    public String getDriverTitl() {
        return titl.getText();
    }

    public void setSummaDeposit(String value) {
        summDeposit.sendKeys(value);
    }

    public void setTimeDeposit(String value) {
       WebElement element = driver.findElement(By.xpath("//li[contains(text(),'"+value+"')]"));
       while (!element.isDisplayed()) {
           selectTimeDeposit.click();
       }
       element.click();
    }

    public void setEveryMounthDeposit(String arg1) {
        everyMounthDeposit.sendKeys(arg1);
    }

    public void setCheckBox(String arg1, String arg2) {
        WebElement elem;
        boolean bool = Boolean.parseBoolean(arg2);
        switch (arg1) {
            case "Ежемесячная капитализация":
                elem=checkBoxEvrMonCapit;
                break;
            case "Частичное снятие":
                elem=partWindwal;
                break;
            default:
                elem=driver.findElement(By.xpath("//*[contains(text(),'"+arg1+"')]"));
                break;
        }
        if (isCheckBox(elem)^bool)
            elem.click();
    }

    private boolean isCheckBox(WebElement element) {
        return element.getAttribute("class").contains("checked");
    }

    public String getResultPole(String key) {
        switch (key) {
            case "Ставка":
                return parserText(Stavka.getText());
            case "К снятию через":
                return parserText(KSnytiu.getText());
            case "Пополнение за":
                return parserText(popolnenie.getText());
            case "Начислено":
                return parserText(nachisleno.getText());
        }
        return null;
    }


    private String parserText(String text) {
        return text.trim().replaceAll("[% ]","").replaceAll(",",".");
    }

}
