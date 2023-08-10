package lotto.controller;

import lotto.model.GenerateLotto;
import lotto.model.Player;
import lotto.model.Rate;
import lotto.validate.Validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {
    private final Player player;
    private final GenerateLotto generateLotto;
    private final int ticket;
    private int[] profit;

    public LottoController(){
        this.player = new Player();
        this.generateLotto = new GenerateLotto();
        this.ticket = priceToTicket();
        this.profit = new int[5];
    }

    public void startLotto() {
        generateLotto.generateLottoNumber(this.ticket);
        printLotto(generateLotto.getMachineNumber(), this.ticket);
        player.setPlayerNumber(lottoInputMessage());    //로또 입력
        player.setBonusNumber(bonusInputMessage());     //보너스 번호 입력
        printResult();                                  //전체 결과 출력
    }

    private int priceToTicket(){
        int price = priceInputMessage();
        return Validate.divideByThousand(price);
    }

    //최종결과 출력
    private void printResult(){
        //전체 수익 계산
        totalProfit();
        //수익률 출력
        printTotalProfit(this.profit);
        printRate(calculateRate(calculateTotalProfit()));
    }

    //전체 수익 계산
    private void totalProfit(){
        List<List<Integer>> machineLotto = generateLotto.getMachineNumber();
        List<Integer> userLotto = player.getPlayerNumber();
        Set<Integer> userSet = new HashSet<>(userLotto);
        int bonusNumber = player.getBonusNumber();

        //로또 몇개 해당되는지 계산
        for(List<Integer> lottoNumbers: machineLotto){
            Set<Integer> machineSet = new HashSet<>(lottoNumbers);
            machineSet.retainAll(userSet);
            int sameNumber = machineSet.size();
            boolean bonusMatch = lottoNumbers.contains(bonusNumber);

            calculateProfit(sameNumber, bonusMatch);
        }
    }

    private void calculateProfit(int sameNumber, boolean bonusMatch) {
        Rate rate = Rate.getRank(sameNumber, bonusMatch);
        if(rate != null){
            this.profit[rate.ordinal()] += 1;
        }
    }

    private int calculateTotalProfit(){
        int totalProfit = 0;
        for(Rate rate: Rate.values()){
            totalProfit += this.profit[rate.ordinal()]*rate.getMoney();
        }
        return totalProfit;
    }


    //수익률 계산
    private double calculateRate(int totalAmount){
        return ((double)totalAmount/this.ticket*1000)*100;
    }
}
