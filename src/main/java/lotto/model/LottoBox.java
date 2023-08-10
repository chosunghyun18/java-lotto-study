package lotto.model;

import java.util.ArrayList;

public class LottoBox {
    private final ArrayList<Lotto> lottoBox;

    public LottoBox(ArrayList<Lotto> lottoArrayList) {
        this.lottoBox = lottoArrayList;
    }

    public ArrayList<Lotto> getLottoBox() {
        return lottoBox;
    }


}
