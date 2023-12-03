package baseball.domain;

import java.util.*;

import static baseball.exception.ErrorCode.INVALID_NUMBER;

public class Numbers {
    private final int MAX_DIGIT = 3;
    private final int DUPLICATE_MIN_CONDITION = 2;
    private final int NOT_EXISTENCE = 0;
    private final String numbers;

    //== Constructor ==//
    private Numbers(String numbers) {
        INVALID_NUMBER.validate(() -> hasDuplicateNumber(numbers));
        INVALID_NUMBER.validate(() -> isExceedMaximumDigit(numbers));

        this.numbers = numbers;
    }

    //== Static Factory Method ==//
    public static Numbers create(String numbers) {
        return new Numbers(numbers);
    }

    private boolean hasDuplicateNumber(String numberInput) {
        String[] numbers = numberInput.split("");
        List<String> splitNumber = Arrays.stream(numbers)
                .toList();
        long duplicateCount = splitNumber.stream()
                .filter(n -> Collections.frequency(splitNumber, n) >= DUPLICATE_MIN_CONDITION)
                .count();
        return duplicateCount != NOT_EXISTENCE;
    }

    private boolean isExceedMaximumDigit(String numberInput) {
        return numberInput.length() > MAX_DIGIT;
    }
}
