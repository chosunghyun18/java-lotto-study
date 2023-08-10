package lotto.controller;

import lotto.model.LottoBox;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        OutputView.requestPrice();
    }

    private void lottoMachineStart() {
        int count = InputView.inputLottoBoxPrice() / 1000;
        OutputView.showLottoCount(count);
    }
}
