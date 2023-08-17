package lotto.view;

import lotto.model.Rate;

import java.util.List;

import static lotto.constant.Constant.*;


public class OutputView {

    //생성된 로또 모두 출력
    public static void printLotto(List<List<Integer>> machineNumber, int ticket){
        System.out.println(ticket+ PRICE_OUTPUT_MESSAGE);
        for(List<Integer> lottoNumbers: machineNumber){
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    //결과 출력
    public static void printTotalProfit(int[] profit){
        System.out.println(PRINT_LOTTERY);
        System.out.println(LINE);
        for(Rate rate:Rate.values()){
            String formattedNumber = String.format("%,d", rate.getMoney());
            System.out.println(rate.getMessage() + " (" + formattedNumber + "원) - " + profit[rate.ordinal()]+ "개");
        }
    }

    //수익률 출력
    public static void printRate(double rate){
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    //에러 메시지 출력
    public static void printErrorMessage(String message){
        System.out.println("[ERROR]" + message);
    }
}
