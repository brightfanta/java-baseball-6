package baseball.exception;

import baseball.view.output.ErrorOutputWriter;

import java.util.function.Supplier;

public class ExceptionHandler {

    public ExceptionHandler() {
    }

    public static <T> T retryOnBusinessException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (BusinessException exception) {
                ErrorOutputWriter.println(exception.getMessage());
            }
        }
    }

    public static <T> T tryOnParseIntException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NumberFormatException exception) {
            throw BusinessException.of(ErrorCode.INVALID_NUMBER, exception);
        }
    }
}
