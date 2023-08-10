package lotto.model;

import java.util.ArrayList;
import java.util.Map;

public class LottoBox {
    private final ArrayList<Lotto> lottoBox;
    private static final Map<MatchResult, Integer> matchCount = Map.of(
            MatchResult.THREE_MATCHES, 0,
            MatchResult.FOUR_MATCHES, 0,
            MatchResult.FIVE_MATCHES, 0,
            MatchResult.SIX_MATCHES, 0,
            MatchResult.FIVE_BONUS_MATCHES, 0
    );

    public LottoBox(ArrayList<Lotto> lottoArrayList) {
        this.lottoBox = lottoArrayList;
    }

    public ArrayList<Lotto> getLottoBox() {
        return lottoBox;
    }

    public Map<MatchResult, Integer> lottoResult(WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoBox) {
            WinningResult winningResult = new WinningResult(lotto, winningNumbers);
            MatchResult result = winningResult.getResult();
            matchCount.put(result, matchCount.get(result)+1);
        }
        return matchCount;
    }

    public double getRevenue(Map<MatchResult, Integer> matchCount) {
        int totalIncome = 0;
        for (Map.Entry<MatchResult, Integer> entry : matchCount.entrySet()) {
            totalIncome += entry.getKey().getPrice() * entry.getValue();
        }

        return Math.round((double) totalIncome/ lottoBox.size() *100) / 100.0 ;
    }

}
