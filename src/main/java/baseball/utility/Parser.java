package baseball.utility;

import baseball.exception.ExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Parser {
    private Parser() {
    }

    public static int parseNumberInput(String numberInput) {
        return ExceptionHandler.tryOnParseIntException(() -> Integer.parseInt(numberInput));
    }

    public static List<Integer> parseNumbers(int number) {
        List<Integer> playerNumbers = new ArrayList<>();
        int[] numbers = Stream.of(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(numbers)
                .forEach(playerNumbers::add);

        return playerNumbers;
    }

    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }
}
