package lotto.model;

import java.util.ArrayList;

public class WinningNumbers {
    private final ArrayList<Integer> winningNumbers;
    private final int bonusNumber;
    private WinningNumbers(ArrayList<Integer> winningNumbers,int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
