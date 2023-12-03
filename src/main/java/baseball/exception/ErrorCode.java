package baseball.exception;

import java.util.function.BooleanSupplier;

public enum ErrorCode {

    INVALID_NUMBER("유효하지 않은 숫자입니다. 다시 입력해 주세요."),
    ;

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public void validate(BooleanSupplier condition) {
        if (isSameCondition(condition)) {
            throw BusinessException.from(this);
        }
    }

    private boolean isSameCondition(BooleanSupplier condition) {
        return condition.getAsBoolean();
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
