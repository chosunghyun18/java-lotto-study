package lotto.model;

import java.util.ArrayList;
import java.util.Map;

public class WinningResult {
    private final Result result;
    private static final int BONUS_NUMBER_MATCH_RESULT = -1;
    private static final int BONUS_NUMBER_NOT_MATCH_RESULT = 5;

    private static final Map<Integer, Result> matchToResultMap = Map.of(
            3, Result.THREE_MATCHES,
            4, Result.FOUR_MATCHES,
            5, Result.FIVE_MATCHES,
            6, Result.SIX_MATCHES,
            -1, Result.FIVE_BONUS_MATCHES
    );

    private WinningResult(Lotto lotto, WinningNumbers winningNumbers) {
        this.result = matchToResultMap.getOrDefault(getMatch(lotto, winningNumbers),Result.NONE);
    }

    private Result getResult() {
        return result;
    }

    private static int getMatch(Lotto lotto, WinningNumbers winningNumbers) {
        int match = 0;
        ArrayList<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        for(int number : numbers){
            if(winningNumbers.getWinningNumbers().contains(number)){
                match +=1;
            }
        }
        if (match == 5) {
            return isBonusNumberMatch(lotto, winningNumbers);
        }
        return match;
    }

    private static int isBonusNumberMatch(Lotto lotto, WinningNumbers winningNumbers) {
        if (lotto.getNumbers().contains(winningNumbers.getBonusNumber())) {
            return BONUS_NUMBER_MATCH_RESULT;
        }
        return BONUS_NUMBER_NOT_MATCH_RESULT;
    }

}
