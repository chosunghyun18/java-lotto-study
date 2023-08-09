package lotto.model;

import java.util.ArrayList;

public class LottoBox {
    private final ArrayList<Lotto> lottoBox;

    private LottoBox(ArrayList<Lotto> lottoArrayList) {
        this.lottoBox = lottoArrayList;
    }

    public ArrayList<Lotto> getLottoBox() {
        return lottoBox;
    }
}
