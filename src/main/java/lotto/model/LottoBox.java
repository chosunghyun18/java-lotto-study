package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LottoBox {
    private final ArrayList<Lotto> lottoBox;
    private Map<MatchResult, Integer> matchCount = new HashMap<>();
    public LottoBox(ArrayList<Lotto> lottoArrayList) {
        this.lottoBox = lottoArrayList;
        matchCount.put(MatchResult.THREE_MATCHES, 0);
        matchCount.put(MatchResult.FOUR_MATCHES, 0);
        matchCount.put(MatchResult.FIVE_MATCHES, 0);
        matchCount.put(MatchResult.SIX_MATCHES, 0);
        matchCount.put(MatchResult.FIVE_BONUS_MATCHES, 0);
        matchCount.put(MatchResult.NONE, 0);
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
        int price = lottoBox.size() * 1000;
        double revenue = (double) totalIncome / price;
        return Math.round(revenue *10000) / 100.0;
    }

}
