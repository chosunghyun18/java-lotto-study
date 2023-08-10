package lotto.model;

import java.util.ArrayList;

public class LottoBox {
    private final ArrayList<Lotto> lottoBox;
    private final int boxPrice;

    public LottoBox(ArrayList<Lotto> lottoArrayList, int boxPrice) {
        this.lottoBox = lottoArrayList;
        this.boxPrice = boxPrice;
    }

    public ArrayList<Lotto> getLottoBox() {
        return lottoBox;
    }

    public double calculatedRevenue(WinningNumbers winningNumbers) {
        int totalIncome = 0;
        for (Lotto lotto : lottoBox) {
            WinningResult winningResult = new WinningResult(lotto, winningNumbers);
            MatchResult result = winningResult.getResult();
            totalIncome += result.getPrice();
        }
        double revenue = (double) totalIncome / lottoBox.size();

        return Math.round(revenue * 100) / 100.0;
    }

    public int getLottoCount() {
        return boxPrice / 1000;
    }
}
