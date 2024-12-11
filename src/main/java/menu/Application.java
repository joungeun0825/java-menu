package menu;

import menu.controller.MenuRecommendController;
import menu.global.view.InputView;
import menu.global.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuRecommendController menuRecommendController = new MenuRecommendController(new InputView(), new OutputView());
        menuRecommendController.run();

    }
}
