package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void play() {
        int amount = InputView.getAmount();
        int ticketCount = amount / 1000;
        OutputView.printTicketCount(ticketCount);

        List<Lotto> tickets = lottoService.generateTickets(ticketCount);
        OutputView.printTickets(tickets);

        LottoWinningNumbers winningNumbers = InputView.getWinningNumbers();
        LottoResult result = lottoService.checkResult(tickets, winningNumbers);

        OutputView.printResult(result);
    }
}
