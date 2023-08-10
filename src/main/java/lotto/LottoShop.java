package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoShop {
    static final int LottoStartNumber = 1;
    static final int LottoEndNumber = 45;
    static final int LottoNumbers = 6;
    static final int PriceOfLotto = 1000;
    static final int LottoResultIndexShift = 3;
    static final int BonusNumberIndex = 6;
    static final int ThreeMatchPrize = 5_000;
    static final int FourMatchPrize = 50_000;
    static final int FiveMatchPrize = 1_500_000;
    static final int FiveAndBonusMatchPrize = 30_000_000;
    static final int SixMatchPrize = 2_000_000_000;
    static final int ThreeMatchIndex = 0;
    static final int FourMatchIndex = 1;
    static final int FiveMatchIndex = 2;
    static final int FiveAndBonusMatchIndex = 4;
    static final int SixMatchIndex = 3;
    static final String MatchStatisticsInstruction = "당첨 통계\n---";
    static final String Unit = "개";
    static final String ThreeMatchInstruction = "3개 일치 (5,000원) - ";
    static final String FourMatchInstruction = "4개 일치 (50,000원) - ";
    static final String FiveMatchInstruction = "5개 일치 (1,500,000원) - ";
    static final String FiveAndBonusMatchInstruction = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    static final String SixMatchInstruction = "6개 일치 (2,000,000,000원) - ";
    static final String ResultStartInstruction = "총 수익률은 ";
    static final String ResultEndInstruction = "%입니다.";
    static final String newLine = "\n";
    static final String comma = ",";
    static final String AmountInstruction = "구입금액을 입력해 주세요.";
    static final String PurchaseInstruction = "개를 구매했습니다.";
    static final String TargetNumberInstruction = "당첨 번호를 입력해 주세요.";
    static final String BonusNumberInstruction = "보너스 번호를 입력해 주세요.";
    static final String ErrorInstruction = "[ERROR] ";
    static final int One = 1;
    private int amount = 0;
    private int numberOfLotto = 0;
    private List<Lotto> lottoList = new ArrayList<>();
    private List<Integer> targetNumbers = new ArrayList<>();
    private int[] LottoResults = new int[5];

    public void setAmount() {
        System.out.println(AmountInstruction);
        String amount = Console.readLine();
        AmountError amountErr = new AmountError();
        amountErr.amountCheck(amount);
        this.amount = Integer.parseInt(amount);
    }
    public void calculateNumberOfLotto() {
        this.numberOfLotto = this.amount/PriceOfLotto;
    }
    public void issuingLottoTickets() {
        System.out.println(this.numberOfLotto + PurchaseInstruction);
        while(this.lottoList.size() < this.numberOfLotto) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoStartNumber, LottoEndNumber, LottoNumbers));
            Collections.sort(numbers);
            Lotto lottoTicket = new Lotto(numbers);
            lottoTicket.printLotto();
            this.lottoList.add(lottoTicket);
        }
    }

    public void setTargetNumbers() {
        System.out.println(TargetNumberInstruction);
        List<Integer> targetNumbers = Arrays.stream(Console.readLine().split(comma))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        TargetNumberError targetNumberErr = new TargetNumberError();
        targetNumberErr.targetNumberCheck(targetNumbers);
        this.targetNumbers = targetNumbers;
    }

    public void setBonusNumber() {
        System.out.println(BonusNumberInstruction);
        int bonusNumber = Integer.parseInt(Console.readLine());
        BonusNumberError BonusNumberErr = new BonusNumberError();
        BonusNumberErr.BonusNumberCheck(bonusNumber);
        this.targetNumbers.add(bonusNumber);
    }

    public int compare(Set<Integer> lotto, Set<Integer> target) {
        Set<Integer> intersection = new HashSet<>(lotto);
        intersection.retainAll(target);
        return intersection.size();
    }

    public void analyzeLotteryResults() {
        Set<Integer> matchSet = new HashSet<>(this.targetNumbers);
        int compareResult;
        for (Lotto lottoTicket : this.lottoList) {
            Set<Integer> lottoSet = new HashSet<>(lottoTicket.getNumbers());
            compareResult = compare(lottoSet, matchSet);
            if (compareResult >= LottoResultIndexShift) {
                this.LottoResults[compareResult-LottoResultIndexShift] += One;
            }
            if (lottoSet.contains(this.targetNumbers.get(BonusNumberIndex)) && compareResult == LottoNumbers) {
                this.LottoResults[SixMatchIndex] -= One;
                this.LottoResults[FiveAndBonusMatchIndex] += One;
            }
        }
    }

    public void printLottoResults() {
        float totalPrize = this.LottoResults[ThreeMatchIndex]*ThreeMatchPrize
                +this.LottoResults[FourMatchIndex]*FourMatchPrize
                +this.LottoResults[FiveMatchIndex]*FiveMatchPrize
                +this.LottoResults[FiveAndBonusMatchIndex]*FiveAndBonusMatchPrize
                +this.LottoResults[SixMatchIndex]*SixMatchPrize;
        System.out.println(MatchStatisticsInstruction);
        System.out.println(ThreeMatchInstruction + this.LottoResults[ThreeMatchIndex] + Unit);
        System.out.println(FourMatchInstruction + this.LottoResults[FourMatchIndex] + Unit);
        System.out.println(FiveMatchInstruction + this.LottoResults[FiveMatchIndex] + Unit);
        System.out.println(FiveAndBonusMatchInstruction + this.LottoResults[FiveAndBonusMatchIndex] + Unit);
        System.out.println(SixMatchInstruction + this.LottoResults[SixMatchIndex] + Unit);
        System.out.println(ResultStartInstruction + Math.round(totalPrize/((float)amount)*100.0 * 100.0) / 100.0 + ResultEndInstruction);
    }
    public void lottoSales() {
        try {
            this.setAmount();
            this.calculateNumberOfLotto();
            this.issuingLottoTickets();
            this.setTargetNumbers();
            this.setBonusNumber();
            this.analyzeLotteryResults();
            this.printLottoResults();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorInstruction + e.getMessage());
        }
    }
}
