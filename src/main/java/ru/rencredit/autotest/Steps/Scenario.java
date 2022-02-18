package ru.rencredit.autotest.Steps;



import cucumber.api.DataTable;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;



public class Scenario {


    @Дано("^открыта страница \"([^.]*)\"$")
    public void openPage(String arg1) throws Throwable {
        HomeSteps homeSteps = new HomeSteps();
        homeSteps.checkTetlePage(arg1);
    }

    @Когда("^нажимается вкладка \"([^\"]*)\"$")
    public void clickDeposit(String arg1) {
        new HomeSteps().clickDeposit(arg1);
    }

    @Тогда("^заголовок сайта \"([^\"]*)\"$")
    public void getTitle(String arg1) {
        new DepositSteps().checkDepositTitle(arg1);
    }

    @Когда("^сумма вклада составляет \"([^\"]*)\"$")
    public void SummaDepositIs(String arg1)  {
        new DepositSteps().setSummaDeposit(arg1);
    }

    @Когда("^срок вклада составлят \"([^\"]*)\"$")
    public void TimeDepositIs(String arg1)  {
        new DepositSteps().setTimeDeposit(arg1);
    }

    @Когда("^ежемесячное пополнение составляет \"([^\"]*)\"$")
    public void EveryMounthDepositIs(String arg1) {
        new DepositSteps().setEveryMounthDeposit(arg1);
    }

    @Когда("^пункт \"([^\"]*)\" в состоянии \"([^\"]*)\"$")
    public void setCheckBox(String arg1, String arg2) {
        new DepositSteps().setCheckBox(arg1,arg2);
    }

    @Тогда("^значения следующих полей равны:$")
    public void checkResultPole(DataTable arg1) {
        new DepositSteps().checkResultPole(arg1);
    }
}
