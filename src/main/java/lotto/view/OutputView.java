package lotto.view;

import java.util.List;

import static lotto.constant.Constant.PRICE_OUTPUT_MESSAGE;

public class OutputView {

    //생성된 로또 모두 출력
    public static void printLotto(List<List<Integer>> machineNumber, int ticket){
        //'총 몇장을 구매 했습니다.'
        System.out.println(ticket+ PRICE_OUTPUT_MESSAGE);
        for(List<Integer> lottoNumbers: machineNumber){
            System.out.println(lottoNumbers);
        }
    }




}
