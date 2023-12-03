package baseball.view.constants;

public enum ResponseMessage {

    //== REQUEST MESSAGE ==//
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
//    REQUEST_VISITING_DAY(
//            String.format(
//                    "%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)",
//                    PROMOTION_MONTH.getValue())
//    ),
    REQUEST_3DIGIT_NUMBER("숫자를 입력해주세요 : "),
    REQUEST_RESTART_OR_NOT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),

    //== RESPONSE MESSAGE ==//
//    RESPONSE_NONEXISTENCE_RESPONSE("없음"),
    RESPONSE_FINISH_GAME("%d개의 개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
