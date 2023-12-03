package baseball.view.output;

import baseball.controller.dto.GameResponse;
import baseball.view.constants.ResponseFormat;

import static baseball.domain.Numbers.*;

public final class GameOutputWriter extends OutputWriter{
    public GameOutputWriter() {
    }

    public static void printMatchingResult(GameResponse gameResponse) {
        int strikeCount = gameResponse.strikeCount();
        int ballCount = gameResponse.ballCount();
        if (strikeCount != NOT_EXISTENCE && ballCount != NOT_EXISTENCE) {
            println(ResponseFormat.BALL_AND_STRIKE.generateFormat(ballCount, strikeCount));
        }
        if (strikeCount != NOT_EXISTENCE && ballCount == NOT_EXISTENCE) {
            println(ResponseFormat.STRIKE_ONLY.generateFormat(strikeCount));
        }
        if (strikeCount == NOT_EXISTENCE && ballCount != NOT_EXISTENCE) {
            println(ResponseFormat.BALL_ONLY.generateFormat(ballCount));
        }
        if (strikeCount == NOT_EXISTENCE && ballCount == NOT_EXISTENCE) {
            println(ResponseFormat.NOTHING.generateFormat(NOT_EXISTENCE));
        }
    }
}
