package lotto.domain;

import java.util.*;

public class Lotto {
    // 하나의 로또
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자 입력");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45 )) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 숫자만 입력 가능");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 입력");
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(WinningLotto winningLotto) {
        return (int) this.numbers.stream().filter(number ->
                winningLotto.getWinningLotto().getNumbers().contains(number)).count();
    }
}
