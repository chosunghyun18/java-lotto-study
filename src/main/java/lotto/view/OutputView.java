package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
   public static void printErrorMessage(String message) {
      System.out.println(message);
   }

   public static void printMoneyMessage() {
      System.out.println("구입금액을 입력해 주세요.");
   }

   public static void printNumberOfTickets(int counts) {
      System.out.println(counts + "개를 구매했습니다.");
   }

   public static void printLottos(List<Lotto> lottos) {
      for (Lotto lotto: lottos) {
         System.out.print("[");
         String joinedNumbers = lotto.getNumbers().stream()
                 .map(String::valueOf)
                 .collect(Collectors.joining(", "));
         System.out.println(joinedNumbers + "]");
      }
   }

   public static void printTotalWinningResult(GameResult result) {
      System.out.println();
      System.out.println("당첨 통계");
      System.out.println("---");

      Map<Rank, Integer> gameResult = result.getGameResult();
      for (Rank rank : Rank.values()) {
         if (rank == Rank.FAIL) continue;
         System.out.println(rank.getMessage() + " ("+ String.format("%,d", rank.getReward())+ "원) - " + gameResult.getOrDefault(rank, 0) + "개");
      }
   }

   public static void printTotalProfit(double profit) {
      System.out.print("총 수익률은 ");
      System.out.printf("%.1f", profit);
      System.out.print("%입니다.");
   }
}