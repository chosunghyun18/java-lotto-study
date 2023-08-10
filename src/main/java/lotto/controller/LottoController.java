package lotto.controller;

import lotto.model.LottoBox;
import lotto.model.MatchResult;
import lotto.model.WinningNumbers;
import lotto.model.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.Map;

public class LottoController {
    public void run() {
        OutputView.requestPrice();
        lottoMachineStart();
    }

    private void lottoMachineStart() {
        LottoBox lottoBox = buildLottobox();
        WinningNumbers winningNumbers = buildWinningNumbers();

        Map<MatchResult, Integer> result = lottoBox.lottoResult(winningNumbers);
        printStatistics(result);
        OutputView.showRevenue(lottoBox.getRevenue(result));
    }

    private LottoBox buildLottobox() {
        int count = InputView.inputLottoBoxPrice() / 1000;
        OutputView.showLottoCount(count);

        LottoBox lottoBox = new LottoBox(LottoGenerator.generateLottoBox(count));
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

    private void printStatistics(Map<MatchResult, Integer> result) {
        OutputView.statisticsLayOut();
        OutputView.bar();
        OutputView.showStatistics(result);
        OutputView.bar();
    }



}
