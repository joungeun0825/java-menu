package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.constant.Menu;
import menu.global.view.InputView;
import menu.global.view.OutputView;
import menu.global.view.console.ConsoleWriter;

import java.util.List;
import java.util.function.Supplier;

public class MenuRecommendController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Coaches coaches = readNames();
        readExceptMenu(coaches);
    }

    private Coaches readNames() {
        Coaches coaches = new Coaches();
        List<String> names = retry(() -> {
            return inputView.readNames();
        });
        names.forEach(coaches::add);
        return coaches;
    }

    private Coaches readExceptMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<Menu> exceptMenus = retry(() -> {
                return inputView.readExceptMenu(coach);
            });
            coach.updateExceptMenus(exceptMenus);
        }
        return coaches;
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }
}
