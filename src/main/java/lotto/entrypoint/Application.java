package lotto.entrypoint;
import static java.lang.System.exit;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.shared.utils.Util;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        String input = Console.readLine().trim();
        try {
            price = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            System.out.println("[ERROR]");
            exit(0);
            //throw new IllegalArgumentException("[ERROR]");
        }
        if (price % 1000 != 0) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }

        int lottoCount = price / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Util.generateLottoNumbers());
            lottos.add(lotto);
            System.out.println(lotto);
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        input = Console.readLine().trim();
        String[] splittedInput = input.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberStr : splittedInput) {
            winningNumbers.add(Integer.parseInt(numberStr.trim()));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        input = Console.readLine().trim();
        int bonusNumber = Integer.parseInt(input);

        System.out.println("당첨 통계");
        System.out.println("---");
        int match3 = (int) lottos.stream().filter(lotto -> lotto.match(winningNumbers) == 3).count();
        int match4 = (int) lottos.stream().filter(lotto -> lotto.match(winningNumbers) == 4).count();
        int match5 = (int) lottos.stream().filter(lotto -> lotto.match(winningNumbers) == 5).count();
        int match5WithBonus = (int) lottos.stream().filter(lotto -> lotto.match(winningNumbers) == 5 && lotto.getNumbers().contains(bonusNumber)).count();
        int match6 = (int) lottos.stream().filter(lotto -> lotto.match(winningNumbers) == 6).count();
        System.out.println("3개 일치 (5,000원) - " + match3 + "개");
        System.out.println("4개 일치 (50,000원) - " + match4 + "개");
        System.out.println("5개 일치 (1,500,000원) - " + match5 + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + match5WithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + match6 + "개");
        System.out.println("총 수익률은 " + (double) Math.round((match3 * 5000 + match4 * 50000 + match5 * 1500000 + match5WithBonus * 30000000 + match6 * 2000000000) / (double) price * 1000) / 10 + "%입니다.");
    }
}
