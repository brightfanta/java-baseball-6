package baseball.view.constants;

public enum ResponseFormat {

    BALL_ONLY("%d볼"),
    STRIKE_ONLY("%d스트라이크"),
    BALL_AND_STRIKE("%d볼 %d스트라이크"),
    NOTHING("낫싱"),
    RESPONSE_FINISH_GAME("%d개의 개의 숫자를 모두 맞히셨습니다! 게임 종료")
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
