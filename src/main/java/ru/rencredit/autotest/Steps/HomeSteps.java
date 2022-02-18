package ru.rencredit.autotest.Steps;


import org.junit.Assert;
import ru.rencredit.autotest.Pages.HomePage;
import ru.yandex.qatools.allure.annotations.Step;

public class HomeSteps {

    @Step ("Титл страницы соответствует {0}")
    public void checkTetlePage(String arg1) {
        Assert.assertTrue(new HomePage().getDriverTitl().contains(arg1));
    }

    @Step ("Нажата вкладка {0}")
    public void clickDeposit(String arg1) {
        new HomePage().clickVkladElem();
    }


}
