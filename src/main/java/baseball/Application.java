package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {

        GameController.startGame();

        GameController.repeatGame();
//        Numbers numbers = GameController.requestNumbers();
//        GameController.responseGameResult(numbers);
    }
}
