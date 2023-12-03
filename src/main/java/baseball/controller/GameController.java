package baseball.controller;

import baseball.controller.dto.GameResponse;
import baseball.domain.Calculator;
import baseball.domain.Numbers;
import baseball.exception.ExceptionHandler;
import baseball.utility.Parser;
import baseball.view.input.InputReader;
import baseball.view.output.GameOutputWriter;

import java.util.List;

import static baseball.view.constants.ResponseMessage.*;

public class GameController {

    private static final Integer REPETITION_CONDITION = 1;
    private static final Integer FINISH_GAME_CONDITION = 2;
    public GameController() {
    }

    public static void startGame() {
        GameOutputWriter.printMessageResponse(START_MESSAGE);
        GameOutputWriter.printNewLine();
    }

    public static void repeatGame() {
        while (true) {
            Numbers numbers = requestNumbers();
            responseGameResult(numbers);

            Integer repetitionNumber = askRepetition();
            if (repetitionNumber.equals(REPETITION_CONDITION)) {
                break;
            }
        }
    }

    public static Numbers requestNumbers() {
        return ExceptionHandler.retryWhenBusinessException(GameController::createGameNumbersFromInput);
    }

    private static Numbers createGameNumbersFromInput() {
        GameOutputWriter.printMessageResponse(REQUEST_3DIGIT_NUMBER);
        String numberInput = InputReader.readInput();
        return Numbers.create(numberInput);
    }

    public static void responseGameResult(Numbers numbers) {
        Calculator calculator = Calculator.create(numbers);
        GameResponse gameResponse = GameResponse.from(calculator);
        GameOutputWriter.printMatchingResult(gameResponse);
    }

    public static Integer askRepetition() {
        GameOutputWriter.printMessageResponse(REQUEST_RESTART_OR_NOT);

        int repetitionNumber = 0;
        List<Integer> repetitionCondition = List.of(1, 2);
        do {
            String repetitionInput = InputReader.readInput();
            repetitionNumber = Parser.parseNumberInput(repetitionInput);
        } while (!repetitionCondition.contains(repetitionNumber));

        return repetitionNumber;
    }
}
