package baseball.utility;

import baseball.exception.ExceptionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern REGEX_PATTERN = Pattern.compile("^\\d{100,999}$");

    private Parser() {
    }

    public static int parseNumberInput(String numberInput) {
        return ExceptionHandler.tryOnParseIntException(() -> Integer.parseInt(numberInput));
    }

    private static boolean matchWithRegex(String input) {
        Matcher matcher = REGEX_PATTERN.matcher(input);
        return !matcher.matches();
    }
}
