package baseball.view.output;

import baseball.view.constants.ResponseMessage;

public class OutputWriter {

    public OutputWriter() {
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printMessageResponse(ResponseMessage responseMessage) {
        println(responseMessage.getMessage());
    }
}
