package lotto.domain;

public class LottoResult {
    private int[] matchCounts = new int[7];

    public void addResult(int matchCount) {
        matchCounts[matchCount]++;
    }

    public int getMatchCount(int count) {
        return matchCounts[count];
    }
}
