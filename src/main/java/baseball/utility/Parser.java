package baseball.utility;

import baseball.exception.ExceptionHandler;

public class Parser {
    private Parser() {
    }

    public static int parseNumberInput(String numberInput) {
        return ExceptionHandler.tryOnParseIntException(() -> Integer.parseInt(numberInput));
    }
}
