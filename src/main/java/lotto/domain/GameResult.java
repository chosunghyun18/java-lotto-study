package lotto.domain;

import java.util.Map;

public class GameResult {
   public Map<Rank, Integer> getGameResult() {
      return gameResult;
   }

   private final Map<Rank, Integer> gameResult;

   public GameResult(Map<Rank, Integer> gameResult) {
      this.gameResult = gameResult;
   }
   private int calculateProfit() {
      int profit = 0;
      for (Rank rank: gameResult.keySet()) {
         profit += rank.getReward() * gameResult.get(rank);
      }
      return profit;
   }

   public double getProfit(int money) {
      int profit = calculateProfit();
      return (double) profit / money * 100;
   }
}
