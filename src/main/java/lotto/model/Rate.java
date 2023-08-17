package lotto.model;

public enum Rate {
    FIFTH("3개 일치", 3, 5_000),
    FOURTH("4개 일치",4,  50_000),
    THIRD("5개 일치", 5, 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치", 5, 30_000_000),
    FIRST("6개 일치", 6, 2_000_000_000);


    private final String message;
    private final int matchNumber;
    private final int money;

    Rate(String message, int matchNumber ,int money){
        this.message = message;
        this.matchNumber = matchNumber;
        this.money = money;
    }

    public String getMessage(){
        return this.message;
    }

    public int getMoney(){
        return this.money;
    }


    public static Rate getRank(int sameNumber, boolean bonusMatch){
        if(sameNumber == 5 && bonusMatch)
            return SECOND;
        for(Rate rate:values()){
            if(rate.matchNumber == sameNumber)
                return rate;
        }
        return null;
    }
}
