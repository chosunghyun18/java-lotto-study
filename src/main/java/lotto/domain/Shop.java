package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Shop {

    private final List<Lotto> lottos;
    private final Money money;
    private final WinnerLotto winnerLotto;
    private final InputView inputView;
    private final OutputView outputView;

    public Shop() {
        this.money = new Money();
        this.winnerLotto = new WinnerLotto();
        this.lottos = new ArrayList<>();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void buyLottos() {
        inputView.showInputMoneyMessage();
        money.inputMoney();
        generateLottos(money.countQuantity());
    }

    public void checkResult() {
        winnerLotto.createWinnerLotto();
        winnerLotto.matchWinnerLotto(lottos);
        winnerLotto.showResultBoard();
        money.showIncomeRate(winnerLotto.calculatePrize());
    }

    public void generateLottos(int quantityOfLotto) {
        for (int i = 0; i < quantityOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            outputView.showLotto(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }
}
