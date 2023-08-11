package lotto.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class InputNumberValidation {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final Integer LIST_LENGTH = 6;
    private static final Integer BONUS_NUMBER_COUNT = 1;

    public static void checkBonusNumberLength(String input) {
        if (input.length() != BONUS_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 숫자는 "+ BONUS_NUMBER_COUNT + " 자리여야 합니다.");
        }
    }

    public static void checkNumberRange(int input) {
        if (!isNumberRangeIsLotto(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 숫자는"+ " 1과 45 이내의 숫자여야 합니다.");
        }
    }

    public static void checkRemainderZero(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 숫자는"+ " 1000으로 나누어 떨어져야 합니다.");
        }
    }
    public static int isNumeric(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 값은 숫자여야 합니다.");
        }
    }

    public static void isNumberLengthCorrect(List<Integer> numbers) {
        if (numbers.size() != LIST_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE+" 입력된 숫자는 6자리여야 합니다.");
        }
    }

    public static void isBonusNumberNotInWInningNumber(ArrayList<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE+"보너스 번호가 당첨번호와 중복됩니다.");
        }
    }
    public static void hasDuplicates(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE+"중복된 숫자가 있습니다.");
        }
    }

    private static boolean isNumberRangeIsLotto(int input) {
        return input < 46 && input > 0;
    }
}
