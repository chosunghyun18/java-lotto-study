package lotto.model;

public enum MatchResult {
    THREE_MATCHES(3,"3개 일치 (5,000)원", 5000),
    FOUR_MATCHES(4, "4개 일치 (50,000원)", 50000),
    FIVE_MATCHES(5,"5개 일치 (1,500,000원)", 1500000),
    SIX_MATCHES(6,"6개 일치 (2,000,000,000원)", 2000000000),
    FIVE_BONUS_MATCHES(-1,"5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    NONE(0,"당첨 안됨 ㅅㄱ", 0);

    private final int match;
    private final String text;
    private final int price;

    MatchResult(int match, String text, int price) {
        this.match = match;
        this.text = text;
        this.price = price;
    }

    public int getMatch() {
        return match;
    }

    public String getText() {
        return text;
    }

    public int getPrice() {
        return price;
    }
}
