package lotto.model;

import lotto.exception.InputNumberValidation;

import java.util.ArrayList;

public class WinningNumbers {
    private final ArrayList<Integer> winningNumbers;
    private final int bonusNumber;
    public WinningNumbers(ArrayList<Integer> winningNumbers,int bonusNumber) {
        InputNumberValidation.isBonusNumberNotInWInningNumber(winningNumbers, bonusNumber);
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
