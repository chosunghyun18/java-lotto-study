package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.LottoController;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController lottoController = new LottoController();
            lottoController.playGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
