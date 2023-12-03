package baseball.view.output;

import baseball.view.constants.ResponseMessage;

sealed class OutputWriter permits ErrorOutputWriter, GameOutputWriter {

    public OutputWriter() {
    }

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printMessageResponse(ResponseMessage responseMessage) {
        print(responseMessage.getMessage());
    }
}
