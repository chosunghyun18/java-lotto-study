package lotto.domain;

import java.util.List;

/**
 * 당첨 로또 클래스
 */
public class WinningLotto {
   private final Lotto winningLotto;
   private final int bonusNumber;

   public WinningLotto (List<Integer> numbers, int bonusNumber) {
      this.winningLotto = new Lotto(numbers);
      validateBonusNumber(bonusNumber);
      this.bonusNumber = bonusNumber;
   }

   private void validateBonusNumber(int bonusNumber) {
      if (bonusNumber < 1 || bonusNumber > 45) {
         throw new IllegalArgumentException("[ERROR] 1~45 범위의 숫자만 입력 가능");
      }
      if (winningLotto.getNumbers().contains(bonusNumber)) {
         throw new IllegalArgumentException("[ERROR] 중복되는 숫자");
      }
   }

   public Lotto getWinningLotto() {
      return winningLotto;
   }

   public int getBonusNumber() {
      return bonusNumber;
   }
}
