package lotto.validate;

public class Validate {
    //1000으로 나누어 떨어지는지 check
    public static int divideByThousand(int price){

        if(price < 0){
            throw new IllegalArgumentException("[ERROR] 0원 미만의 금액");
        }
        else if(price%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아님");
        }
        return price/1000;
    }

    //정수 형식이 맞는지 확인
    public static Integer parseInt(String inputNumber){
        try{
            return Integer.parseInt(inputNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수 형식이 아님");
        }
    }
}