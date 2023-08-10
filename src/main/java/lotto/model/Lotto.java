package lotto.model;

import java.util.List;

//default 생성자, 필드 추가 불가능
//로또 번호 validate 측정하는 클래스

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 미만 또는 초과하여 입력함");
        }
    }

    // TODO: 추가 기능 구현


}
