package menu.global.view;

import menu.global.view.console.ConsoleWriter;

public class OutputView {
    private static final String INPUT_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public void printInputCoachNameMessage() {
        ConsoleWriter.printlnMessage(INPUT_COACH_NAME_MESSAGE);
    }
}
