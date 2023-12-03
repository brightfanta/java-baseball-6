package baseball.view.constants;

public enum ResponseFormat {

    BALL_ONLY("%d볼"),
    STRIKE_ONLY("%d\\스트라이크"),
    BALL_AND_STRIKE("%d볼 %d\\스트라이크"),
    NOTHING("낫싱"),
    ;

    private final String format;

    ResponseFormat(String format) {
        this.format = format;
    }

    //== Utility Method ==//
    public String generateFormat(Object... objects) {
        return String.format(format, objects);
    }
}
