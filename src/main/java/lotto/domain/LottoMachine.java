package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 로또를 생성하고 반환
 * 2. 로또 검사
 */
public class LottoMachine {

   /*
   금액 받아서 그 개수만큼 로또 생성
    */
   public int calculateLottoCount(int money) {
      validateMoney(money);
      return money / 1000;
   }

   public List<Lotto> generateLottos (int count) {
      List<Lotto> lottos = new ArrayList<>();
      for (int i = 0; i < count; i++) {
         Lotto lotto = generateRandomLotto();
         lottos.add(lotto);
      }
      return lottos;
   }

   private void validateMoney(int money) {
      if (money < 1000) {
         throw new IllegalArgumentException("[ERROR] 금액 부족, 1000원 이상 구매 가능");
      }
      if (money % 1000 != 0) {
         throw new IllegalArgumentException("[ERROR] 1000원 단위로만 구매 가능");
      }
   }

   private Lotto generateRandomLotto() {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      return new Lotto(numbers);
   };

   public GameResult checkLotto(WinningLotto winningLotto, List<Lotto> lottos) {
      Map<Rank, Integer> result = new HashMap<>();
      for (Lotto playerLotto : lottos) {
         int matchingNumbers = playerLotto.countMatchingNumbers(winningLotto);
         boolean isBonus = playerLotto.getNumbers().contains(winningLotto.getBonusNumber());

         Rank rank = Rank.findRank(matchingNumbers, isBonus);
         result.put(rank, result.getOrDefault(rank, 0)+1);
      }

      return new GameResult(result);
   }
}
