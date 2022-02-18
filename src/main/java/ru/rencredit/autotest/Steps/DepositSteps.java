package ru.rencredit.autotest.Steps;


import cucumber.api.DataTable;
import org.junit.Assert;
import ru.rencredit.autotest.Pages.DepositPage;
import ru.yandex.qatools.allure.annotations.Step;

public class DepositSteps {

    @Step("Заголовок сайта соответствует {0}")
    public void checkDepositTitle(String arg1) {
        Assert.assertEquals(arg1,new DepositPage().getDriverTitl());
    }

    @Step("Сумма вклада составляет {0}")
    public void setSummaDeposit(String arg1) {
        new DepositPage().setSummaDeposit(arg1);
    }

    @Step("Срок вклада составляет {0}")
    public void setTimeDeposit(String arg1) {
        new DepositPage().setTimeDeposit(arg1);
    }

    @Step("Сумма ежемесячного пополнения составляет {0}")
    public void setEveryMounthDeposit(String arg1) {
        new DepositPage().setEveryMounthDeposit(arg1);
    }

    @Step("Позиция {0} установлено в {1}")
    public void setCheckBox(String arg1, String arg2) {
        new DepositPage().setCheckBox(arg1,arg2);
    }

    @Step("Результаты полей")
    public void checkResultPole(DataTable arg1) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exp) {exp.printStackTrace();}
        arg1.asMap(String.class, String.class).forEach((key,value) ->
                Assert.assertEquals(Double.parseDouble(value),
                        Double.parseDouble( new DepositPage().getResultPole(key)),0.001)
        );

    }
}
