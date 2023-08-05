package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputValidate;
import lotto.validate.MoneyValidate;
import lotto.view.OutputView;

public class Money {

    private static final int UNIT = 1_000;
    private int givenMoney;
    private final OutputView outputView;
    private final MoneyValidate moneyValidate;
    private final InputValidate inputValidate;

    public Money() {
        this.outputView = new OutputView();
        this.moneyValidate = new MoneyValidate();
        this.inputValidate = new InputValidate();
    }

    public void inputMoney() {
        String input = Console.readLine();
        Integer inputNumber = inputValidate.inputSingleNumberValidate(input);
        this.givenMoney = moneyValidate.checkMoneyValidate(inputNumber, UNIT);
    }

    public int countQuantity() {
        int quantity = (givenMoney / UNIT);
        outputView.showQuantityMessage(quantity);
        return quantity;
    }

    public void showIncomeRate(Integer prize) {
        double rate = (double) prize / givenMoney * (100);
        outputView.showIncome(rate);
    }
}
