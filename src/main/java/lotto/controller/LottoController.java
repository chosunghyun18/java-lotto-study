package lotto.controller;

import lotto.model.GenerateLotto;
import lotto.model.Player;

import static lotto.view.InputView.priceInputMessage;

public class LottoController {
    private final Player player;
    private final GenerateLotto generateLotto;

    //TODO 여기 다시 생각해보기.
    public LottoController(){
        this.player = new Player();
        this.generateLotto = new GenerateLotto();
    }

    public void startLotto() {
        getPriceInput();
    }

    //사용자에게 값 받음
    public void getPriceInput(){
        priceInputMessage();
        player.getLottoPrice();

    }

}
