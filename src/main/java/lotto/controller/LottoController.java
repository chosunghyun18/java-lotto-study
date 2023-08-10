package lotto.controller;

import lotto.model.LottoBox;
import lotto.model.WinningNumbers;
import lotto.model.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;

public class LottoController {
    public void run() {
        OutputView.requestPrice();
    }

    private void lottoMachineStart() {
        LottoBox lottoBox = buildLottobox();
        WinningNumbers winningNumbers = buildWinningNumbers();


    }

    private LottoBox buildLottobox() {
        int count = InputView.inputLottoBoxPrice() / 1000;
        OutputView.showLottoCount(count);

        LottoBox lottoBox = LottoGenerator.generateLottoBox(count);
        OutputView.showLottoBox(lottoBox);
        return lottoBox;
    }

    private WinningNumbers buildWinningNumbers() {
        OutputView.requestWinningNumber();
        ArrayList<Integer> winningNumber = InputView.inputWinningNumber();

        OutputView.requestBounusNumber();
        int bonusNumber = InputView.inputBonusNumber();

        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private 

}
