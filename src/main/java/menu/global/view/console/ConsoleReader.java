package menu.global.view.console;

import camp.nextstep.edu.missionutils.Console;
import menu.global.exception.CustomException;
import menu.global.exception.ErrorMessage;

public final class ConsoleReader {
    public static String enterMessage() {
        return Validator.validate(Console.readLine().trim().replace("//s",""));
    }

    private static class Validator {
        public static String validate(String message) {
            validateBlankInput(message);
            return message;
        }

        private static void validateBlankInput(String message) {
            if (message.isEmpty()) {
                throw CustomException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }
    }
}