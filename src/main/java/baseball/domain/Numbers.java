package baseball.domain;

import baseball.utility.Parser;

import java.util.*;

import static baseball.exception.ErrorCode.INVALID_NUMBER;

public class Numbers {
    public static final int MAX_DIGIT = 3;
    public static final int NOT_EXISTENCE = 0;
    private final int DUPLICATE_MIN_CONDITION = 2;
//    private static final Pattern REGEX_PATTERN = Pattern.compile("^\\d{100,999}$");
    private final List<Integer> numbers;

    //== Constructor ==//
    private Numbers(String numbers) {
//        INVALID_NUMBER.validate(() -> isOnlyDigit(numbers));
        int number = Parser.parseNumberInput(numbers);
        INVALID_NUMBER.validate(() -> hasDuplicateNumber(numbers));
        INVALID_NUMBER.validate(() -> isExceedMaximumDigit(numbers));

        this.numbers = Parser.parseNumbers(number);
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
        return duplicateCount > NOT_EXISTENCE;
    }

    private boolean isExceedMaximumDigit(String numberInput) {
        return numberInput.length() > MAX_DIGIT;
    }

//    private boolean isOnlyDigit(String inputs) {
//        return !matchWithRegex(inputs);
//    }
//
//    private boolean matchWithRegex(String input) {
//        Matcher matcher = REGEX_PATTERN.matcher(input);
//        return !matcher.matches();
//    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
