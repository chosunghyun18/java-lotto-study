package lotto.model;

import java.util.HashSet;
import java.util.List;

import static lotto.constant.Constant.END_NUMBER;
import static lotto.constant.Constant.START_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoSize(numbers);
        lottoNumberRepeat(numbers);
        lottoNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    //로또 숫자 몇개인지
    private void lottoSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 미만 또는 초과하여 입력함");
        }
    }

    //로또 숫자 반복되는지
    private void lottoNumberRepeat(List<Integer> numbers){
        HashSet<Integer> lottoSet = new HashSet<>(numbers);
        if(lottoSet.size() < numbers.size()){
            throw new IllegalArgumentException("[ERROR] 반복되는 숫자를 입력함");
        }
    }

    //로또 올바른 범위 내에 있는지
    private void lottoNumberRange(List<Integer> numbers){
        boolean inRange = numbers.stream().allMatch(num -> num >=START_NUMBER && num <= END_NUMBER);
        if(!inRange){
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 정수가 아님");
        }
    }
}
