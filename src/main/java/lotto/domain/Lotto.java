package lotto.domain;

import lotto.validate.LottoValidate;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidate.lottoNumbersRuleValidate(numbers);
        this.numbers = numbers;
    }
    public ScoreBoard matchNumbers(Lotto winnerLotto, Integer winnerBonusNumber) {
        Integer countMatchNumber = checkWinnerBaseNumbers(winnerLotto);
        boolean checkWinnerBonusNumber = numbers.contains(winnerBonusNumber);
        return ScoreBoard.getScoreBoardResultByMatchResult(countMatchNumber, checkWinnerBonusNumber);
    }
    public Integer checkWinnerBaseNumbers(Lotto winnerLotto) {
        int countBaseNumber = 0;
        for (Integer number : this.numbers) {
            if (winnerLotto.checkNumber(number)) {
                countBaseNumber += 1;
            }
        }
        return countBaseNumber ;
    }
    public Boolean checkNumber(Integer number) {
        return this.numbers.contains(number);
    }
}
