package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoBox;
import lotto.model.MatchResult;

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

    public static void showStatistics(MatchResult matchResult, int count) {
        System.out.println(matchResult.getText()+ " - " + count + "개");
    }

    public static void showRevenue(int revenue) {
        System.out.println("총 수익률은 " + revenue + "%입니다.");
    }

    public static void bar() {
        System.out.println("---");
    }
}
