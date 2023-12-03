package baseball.controller;

import baseball.domain.Numbers;
import baseball.exception.ExceptionHandler;
import baseball.view.input.InputReader;
import baseball.view.output.GameOutputWriter;

import static baseball.view.constants.ResponseMessage.START_MESSAGE;

public class GameController {
    public GameController() {
    }

    public static Numbers requestNumbers() {
        GameOutputWriter.printMessageResponse(START_MESSAGE);
        return ExceptionHandler.retryOnBusinessException(GameController::createGameNumbersFromInput);
    }

    private static Numbers createGameNumbersFromInput() {
        String numberInput = InputReader.readInput();
        return Numbers.create(numberInput);
    }
}
