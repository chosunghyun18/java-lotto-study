package lotto;

import lotto.view.OutputView;

import lotto.domain.Shop;

public class Application {

    public static void main(String[] args) {
        Shop shop = new Shop();
        try {
            shop.buyLottos();
            shop.checkResult();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(String.valueOf(e));
        }
    }
}
