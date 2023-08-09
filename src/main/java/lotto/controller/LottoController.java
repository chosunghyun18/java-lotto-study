package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class LottoController {
   Player player = new Player();
   LottoMachine lottoMachine = new LottoMachine();
   public void playGame() {
      try {
         // 사용자가 구매 금액 입력
         int money = InputView.lottoPurchaseMoney();
         // 구매한 금액으로 구매 갯수 계산해서 반환
         int lottoCount = lottoMachine.calculateLottoCount(money);
         OutputView.printNumberOfTickets(lottoCount);

         // 로또기계는 사용자에게 받은 금액으로 로또를 자동 생성함
         List<Lotto> lottos = lottoMachine.generateLottos(lottoCount);
         player.purchaseLotto(lottos);
         OutputView.printLottos(player.getLottos());

         // 사용자가 당첨번호 입력
         List<Integer> winningNumbers = InputView.winningNumbers();
         // 보너스번호 입력
         int bonusNumber = InputView.bonusNumber();
         WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

         GameResult result = lottoMachine.checkLotto(winningLotto, player.getLottos());
         OutputView.printTotalWinningResult(result);
         OutputView.printTotalProfit(result.getProfit(money));
      } catch (NumberFormatException e) {
         throw new IllegalArgumentException();
      }

   }
}
