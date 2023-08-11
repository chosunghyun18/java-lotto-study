package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoBox;
import lotto.model.MatchResult;

import java.util.Map;

import static lotto.model.MatchResult.*;

public class OutputView {
    public static void requestPrice() {
        System.out.println("구입 금액을 입력해 주세요");
    }

    public static void showLottoCount(int count) {
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void showLottoBox(LottoBox lottoBox) {
        for (Lotto lotto : lottoBox.getLottoBox()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void requestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBounusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void statisticsLayOut() {
        System.out.println("당첨 통계");
    }

    public static void showStatistics(Map<MatchResult, Integer> result) {
        System.out.println(THREE_MATCHES.getText()+ " - " + result.get(THREE_MATCHES) + "개");
        System.out.println(FOUR_MATCHES.getText()+ " - " + result.get(FOUR_MATCHES) + "개");
        System.out.println(FIVE_MATCHES.getText()+ " - " + result.get(FIVE_MATCHES) + "개");
        System.out.println(SIX_MATCHES.getText()+ " - " + result.get(SIX_MATCHES) + "개");
        System.out.println(FIVE_BONUS_MATCHES.getText()+ " - " + result.get(FIVE_BONUS_MATCHES) + "개");
    }

    public static void showRevenue(double revenue) {
        System.out.println("총 수익률은 " + revenue + "%입니다.");
    }

    public static void bar() {
        System.out.println("---");
    }
}
