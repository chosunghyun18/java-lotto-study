package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    final String Delimiter = ", ";
    final String Prefix = "[";
    final String Suffix = "]";
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> overlap = new HashSet<>(numbers);
        if (overlap.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printLotto() {
        String result = this.numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(Delimiter, Prefix, Suffix));
        System.out.println(result);
    }
}
