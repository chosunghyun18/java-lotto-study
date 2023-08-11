package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_MIN = 1;

    public List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateLotto());
        }
        return tickets;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6));
    }

    public LottoResult checkResult(List<Lotto> tickets, LottoWinningNumbers winningNumbers) {
        LottoResult result = new LottoResult();

        for (Lotto ticket : tickets) {
            int matchCount = winningNumbers.matchCount(ticket);
            if (matchCount == 5 && winningNumbers.matchBonus(ticket)) {
                result.addResult(6);  // 보너스 번호가 일치하면 6으로 처리
            } else {
                result.addResult(matchCount);
            }
        }

        return result;
    }
}
