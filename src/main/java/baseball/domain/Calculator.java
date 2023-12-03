package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Numbers.MAX_DIGIT;

public class Calculator {

    private static final Integer startInclusiveNumber = 1;
    private static final Integer endInclusiveNumber = 9;
    private final Numbers numbers;
    private final List<Integer> computerNumbers;
    private Calculator(Numbers numbers) {
        this.numbers = numbers;
        this.computerNumbers = generateRandomNumber();
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < MAX_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(startInclusiveNumber, endInclusiveNumber);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public static Calculator create(Numbers numbers) {
        return new Calculator(numbers);
    }
    
    public Integer calculateStrikeCount() {
        List<Integer> playerNumbers = numbers.getNumbers();
        int strikeCount = 0;
        for (int i = 0; i < MAX_DIGIT; i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public Integer calculateSameNumberCount() {
        List<Integer> playerNumbers = numbers.getNumbers();
        int sameNumberCount = 0;
        sameNumberCount += playerNumbers.stream()
                .filter(computerNumbers::contains)
                .count();
        return sameNumberCount;
    }
}
