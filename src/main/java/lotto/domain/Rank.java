package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Rank {

   FIRST_REWARD(6, 2_000_000_000, "6개 일치"), // 6개 일치
   SECOND_REWARD(5, 30_000_000, "5개 일치, 보너스 볼 일치"), // 5개 + 보너스 일치
   THIRD_REWARD(5, 1_500_000, "5개 일치"), // 5개 일치
   FOURTH_REWARD(4, 50_000, "4개 일치"), // 4개 일치
   FIFTH_REWARD(3, 5_000, "3개 일치"), // 3개 일치
   FAIL(0, 0, ""); // 미당첨

   private final int matchCount;
   private final int reward;
   private final String message;

   Rank(int matchCount, int reward, String message) {
      this.matchCount = matchCount;
      this.reward = reward;
      this.message = message;
   }

   public static Rank findRank(int matchCount, boolean isBonus) {
      if (matchCount == 5 && isBonus) return SECOND_REWARD;
      for (Rank rank : values()) {
         if (rank.matchCount == matchCount) return rank;
      }
      return FAIL;
   }


   public int getMatchCount() {
      return matchCount;
   }

   public int getReward() {
      return reward;
   }

   public String getMessage() {
      return message;
   }
}
