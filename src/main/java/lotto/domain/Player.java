package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
   // 로또 리스트
   private final List<Lotto> lottos;

   public Player() {
      this.lottos = new ArrayList<>();
   }

   public List<Lotto> getLottos() {
      return lottos;
   }

   public void purchaseLotto(List<Lotto> lottolist) {
      lottos.addAll(lottolist);
   }
}
