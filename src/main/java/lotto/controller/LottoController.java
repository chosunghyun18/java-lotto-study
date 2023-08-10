package lotto.controller;

import lotto.model.GenerateLotto;
import lotto.model.Player;
import lotto.validate.Validate;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLotto;

public class LottoController {
    private final Player player;
    private final GenerateLotto generateLotto;
    private final int ticket;

    public LottoController(){
        this.player = new Player();
        this.generateLotto = new GenerateLotto();
        this.ticket = priceToTicket();
    }

    public void startLotto() {
        generateLotto.generateLottoNumber(this.ticket);
        printLotto(generateLotto.getMachineNumber(), this.ticket);
        player.setPlayerNumber(lottoInputMessage());    //로또 입력
        player.setBonusNumber(bonusInputMessage());     //보너스 번호 입력
    }

    private int priceToTicket(){
        int price = priceInputMessage();
        return Validate.divideByThousand(price);
    }
}
