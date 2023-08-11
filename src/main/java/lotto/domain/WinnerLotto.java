package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.validate.InputValidate;
import lotto.validate.LottoValidate;
import lotto.view.InputView;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinnerLotto {

    private Lotto winningNumber;
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
        this.winningNumber = inputWinningNumber();
        this.bonusNumber = inputBonusNumber();
    }

    public Lotto inputWinningNumber() {
        inputView.showInputLottoNumberMessage();
        String inputNumbers = Console.readLine();
        return new Lotto(lottoNumbersValidate(inputNumbers));
    }

    public Integer inputBonusNumber() {
        inputView.showInputBonusNumberMessage();
        String inputNumber = Console.readLine();
        return lottoBonusNumberValidate(inputNumber);
    }

    private Integer lottoBonusNumberValidate(String inputNumber) {
        int givenNumber = Integer.parseInt(inputNumber);
        if (1 > givenNumber || givenNumber > 46) throw new IllegalArgumentException("입력 범위 밖.");
        if(this.winningNumber.existNumber(givenNumber)) throw new IllegalArgumentException("보너스 번호가 이미 당첨 번호에 있습니다.");
        return givenNumber ;
    }

    public void matchWinnerLotto(Set<Lotto> lottos) {
        for (Lotto userLotto : lottos) {
            ScoreBoard result = userLotto.matchNumbers(this.winningNumber, this.bonusNumber);
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
