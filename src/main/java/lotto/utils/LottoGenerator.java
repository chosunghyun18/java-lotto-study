package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    public static Lotto generateLotto() {
        List<Integer> numbers =Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers.stream().sorted().collect(Collectors.toList()));
    }

    public static ArrayList<Lotto> generateLottoBox(int count) {
        ArrayList<Lotto> lottoBox = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoBox.add(generateLotto());
        }
        return lottoBox;
    }
}
