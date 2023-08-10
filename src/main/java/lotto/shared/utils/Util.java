package lotto.shared.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
  @SuppressWarnings(value = "unused")
  private Util() {
    throw new AssertionError("This class should not be instantiated.");
  }
  public static List<Integer> generateLottoNumbers() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }
}
