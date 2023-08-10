package lotto.model;

import java.util.ArrayList;
import java.util.Map;

public class WinningResult {
    private final MatchResult matchResult;
    private static final int BONUS_NUMBER_MATCH= -1;
    private static final int BONUS_NUMBER_NOT_MATCH = 5;

    private static final Map<Integer, MatchResult> matchToResultMap = Map.of(
            3, MatchResult.THREE_MATCHES,
            4, MatchResult.FOUR_MATCHES,
            5, MatchResult.FIVE_MATCHES,
            6, MatchResult.SIX_MATCHES,
            -1, MatchResult.FIVE_BONUS_MATCHES
    );

    private WinningResult(Lotto lotto, WinningNumbers winningNumbers) {
        this.matchResult = matchToResultMap.getOrDefault(getMatch(lotto, winningNumbers), MatchResult.NONE);
    }

    private MatchResult getResult() {
        return matchResult;
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
            return BONUS_NUMBER_MATCH;
        }
        return BONUS_NUMBER_NOT_MATCH;
    }

}
