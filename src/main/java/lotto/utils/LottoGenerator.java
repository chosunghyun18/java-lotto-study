package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    public static Lotto generateLotto() {
        List<Integer> numbers =Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers.stream().sorted().collect(Collectors.toList()));
    }
}
