package lotto.domain;

import java.util.List;

public class LottoWinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream().filter(winningNumbers.getNumbers()::contains).count();
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
