package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AmountError{
    final int zero = 0;
    final String IndivisibleErrorString = "금액이 1000으로 나누어 떨어지지 않습니다.";
    final String NonPositiveErrorString = "금액은 양수여야합니다.";
    final String NonDigitErrorString = "금액은 숫자로만 이루어져야합니다.";
    final String digitRegex = "\\d+";
    public void amountCheck(String amount) {
        if (!amount.matches(digitRegex)) {
            throw new IllegalArgumentException(NonDigitErrorString);
        }
        int intAmount = Integer.parseInt(amount);
        if ((intAmount % LottoShop.PriceOfLotto) != zero) {
            throw new IllegalArgumentException(IndivisibleErrorString);
        }
        if (intAmount <= zero) {
            throw new IllegalArgumentException(NonPositiveErrorString);
        }
    }
}

class TargetNumberError{
    final int zero = 0;
    final String InvalidNumberOfTargetNumbersErrorString = "로또 번호는 6개입니다.";
    final String InvalidRangeOfNumberErrorString = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public void targetNumberCheck(List<Integer> targetNumbers) {
        if (targetNumbers.size() != LottoShop.LottoNumbers) {
            throw new IllegalArgumentException(InvalidNumberOfTargetNumbersErrorString);
        }
        Set<Integer> overlap = new HashSet<>(targetNumbers);
        if (overlap.size() != LottoShop.LottoNumbers) {
            throw new IllegalArgumentException(InvalidNumberOfTargetNumbersErrorString);
        }
        for (int i = zero; i < LottoShop.LottoNumbers; i++) {
            rangeCheck(targetNumbers, i);
        }
    }

    public void rangeCheck(List<Integer> targetNumbers, int i) {
        if (targetNumbers.get(i) < LottoShop.LottoStartNumber || targetNumbers.get(i) > LottoShop.LottoEndNumber) {
            throw new IllegalArgumentException(InvalidRangeOfNumberErrorString);
        }
    }
}

class BonusNumberError{
    final String InvalidRangeOfNumberErrorString = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public void BonusNumberCheck(int BonusNumber) {
        if (BonusNumber < LottoShop.LottoStartNumber || BonusNumber > LottoShop.LottoEndNumber) {
            throw new IllegalArgumentException(InvalidRangeOfNumberErrorString);
        }
    }
}
