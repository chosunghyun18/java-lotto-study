package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {
    public static void printTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }
    public static void printResult(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5,000원) - %d개%n", result.getMatchCount(3));
        System.out.printf("4개 일치 (50,000원) - %d개%n", result.getMatchCount(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", result.getMatchCount(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", result.getMatchCount(6) - result.getMatchCount(5));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", result.getMatchCount(6));
    }
}