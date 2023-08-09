package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
   public static int lottoPurchaseMoney() {
      System.out.println();
      System.out.println("구입금액을 입력해 주세요.");
      return parseInt(Console.readLine());
   }

   public static List<Integer> winningNumbers() {
      System.out.println();
      System.out.println("당첨 번호를 입력해 주세요.");
      String inputNumbers = Console.readLine();

      return Arrays.stream(inputNumbers.split(","))
              .map(String::trim) // 공백 제거
              .map(Integer::parseInt) // 문자열을 정수로 변환
              .collect(Collectors.toList()); // 리스트로 변환
   }

   public static int bonusNumber() {
      System.out.println();
      System.out.println("보너스 번호를 입력해 주세요.");
      return parseInt(Console.readLine());
   }

   private static Integer parseInt(String inputString) {
      try {
         return Integer.parseInt(inputString);
      } catch (NumberFormatException e) {
         throw new IllegalArgumentException("[ERROR] 잘못된 형식의 숫자입니다");
      }
   }
}
