package lotto.model;

import java.util.List;

import static lotto.constant.Constant.END_NUMBER;
import static lotto.constant.Constant.START_NUMBER;

public class Player {
    private int bonusNumber;
    private List<Integer> playerNumber;  //6개 숫자 check 필요
    private Lotto lotto;


    //입력받은 로또 값 어케 할지 : validate check (Lotto 클래스 사용)
    public void setPlayerNumber(List<Integer> playerLotto) {
        lotto = new Lotto(playerLotto);
        this.playerNumber = playerLotto;
    }

    //입력받은 보너스 넘버 어떻게 할지 : validate check (로또와 중복되는지 확인, 1~45 사이 숫자인지 확인)
    public void setBonusNumber(int bonusNumber){
        numberRepeat(bonusNumber);
        numberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public List<Integer> getPlayerNumber(){
        return playerNumber;
    }

    private void numberRepeat(int bonusNumber){
        if(this.playerNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 이미 로또에 존재하는 숫자임");
        }
    }

    private void numberRange(int bonusNumber){
        if(!(bonusNumber>=START_NUMBER && bonusNumber<=END_NUMBER)){
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 정수가 아님");
        }
    }

}
