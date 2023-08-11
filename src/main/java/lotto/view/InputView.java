package lotto.view;

import lotto.domain.LottoWinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getAmount() {
        System.out.print("구입금액을 입력해 주세요: ");
        return scanner.nextInt();
    }

    public static LottoWinningNumbers getWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요 (예: 1,2,3,4,5,6): ");
        scanner.nextLine();
        List<Integer> winningNumbers = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.print("보너스 번호를 입력해 주세요: ");
        int bonusNumber = scanner.nextInt();

        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }
}
