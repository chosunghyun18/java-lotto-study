package lotto.domain;

import lotto.validate.InputValidate;
import lotto.validate.LottoValidate;
import lotto.view.InputView;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerLotto {

    private Lotto lotto;
    private Integer bonusNumber;
    private final Map<ScoreBoard, Integer> scoreResult;
    private final InputView inputView;
    private final InputValidate inputValidate;

    public WinnerLotto() {
        this.scoreResult = new HashMap<>();
        this.inputView = new InputView();
        this.inputValidate = new InputValidate();
    }

    public void createWinnerLotto() {
        this.lotto = new Lotto(inputWinnerLottoNumbers());
        this.bonusNumber = inputBonusNumber();
    }

    public List<Integer> inputWinnerLottoNumbers() {
        inputView.showInputLottoNumberMessage();
        String inputNumbers = Console.readLine();
        return lottoNumbersValidate(inputNumbers);
    }

    public Integer inputBonusNumber() {
        inputView.showInputBonusNumberMessage();
        return Integer.parseInt(Console.readLine());
    }

    public void matchWinnerLotto(List<Lotto> lottos) {
        for (Lotto userLotto : lottos) {
            ScoreBoard result = userLotto.matchNumbers(this.lotto, this.bonusNumber);
            scoreResult.put(result, scoreResult.getOrDefault(result, 0) + 1);
        }
    }

    public void showResultBoard() {
        ScoreBoard.showResultBoard(scoreResult, 0);
    }

    public Integer calculatePrize() {
        return ScoreBoard.calculatePrize(scoreResult);
    }

    public List<Integer> lottoNumbersValidate(String givenNumbers) {
        List<String> givenNumberStrings = Arrays.asList(givenNumbers.split(","));
        List<Integer> checkedNumbers = inputValidate.inputNumbersIntegerValidate(
            givenNumberStrings);
        LottoValidate.lottoNumbersRuleValidate(checkedNumbers);
        return checkedNumbers;
    }
}
