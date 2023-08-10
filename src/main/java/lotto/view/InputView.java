package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.Constant.*;
import static lotto.validate.Validate.parseInt;

public class InputView {
    public static int priceInputMessage(){
        System.out.println(PRICE_INPUT_MESSAGE);
        String price = Console.readLine();
        return parseInt(price);
    }

    public static List<Integer> lottoInputMessage(){
        System.out.println(LOTTO_INPUT_MESSAGE);
        String lottoNumber = Console.readLine();
        //',' 기준으로 잘라서 리스트로 만들기
        try{
            return Arrays.stream(lottoNumber.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수 형식이 아님");
        }
    }

    public static int bonusInputMessage(){
        System.out.println(BONUS_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        return parseInt(bonusNumber);
    }

}
