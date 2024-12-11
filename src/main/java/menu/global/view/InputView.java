package menu.global.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.constant.Menu;
import menu.global.exception.ErrorMessage;
import menu.global.view.console.ConsoleReader;
import menu.global.view.console.ConsoleWriter;
import menu.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = ",";

    public List<String> readNames() {
        ConsoleWriter.printlnMessage("코치의 이름을 입력해 주세요. (, 로 구분)");
        return processNames(ConsoleReader.enterMessage(), SEPARATOR);
    }

    public List<Menu> readExceptMenu(Coach coach) {
        ConsoleWriter.printlnFormat("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coach.getName());
        return processExceptMenus(Console.readLine().trim().replaceAll("\\s",""), SEPARATOR);
    }

    private static List<String> processNames(String message, String separator) {
        List<String> coaches = Arrays.stream(split(message, separator))
                .map(name -> {
                    InputValidator.checkBound(name.length(),2,4, ErrorMessage.INVALID_INPUT_NAME_LENGTH_ERROR.getMessage());
                    return name;
                })
                .collect(Collectors.toList());

        InputValidator.checkBound(coaches.size(),2,5, ErrorMessage.INVALID_INPUT_LENGTH_ERROR.getMessage());
        return coaches;
    }

    private static List<Menu> processExceptMenus(String message, String separator) {
        List<Menu> menus = Arrays.stream(split(message, separator))
                .map(menu -> {
                    return Menu.from(
                            menu
                    );
                })
                .collect(Collectors.toList());
        InputValidator.checkBound(menus.size(),0,2, ErrorMessage.INVALID_INPUT_LENGTH_ERROR.getMessage());
        return menus;
    }

    private static String[] split(String message, String separator) {
        return message.split(separator, -1);
    }
}
