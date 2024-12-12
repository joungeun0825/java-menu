package menu.global.view;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommend;
import menu.domain.constant.Category;
import menu.domain.constant.Menu;
import menu.global.view.console.ConsoleWriter;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RECOMMEND_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void printRecommendStartMessage() {
        ConsoleWriter.printlnMessage(RECOMMEND_START_MESSAGE);
    }

    public void printResult(Coaches coaches, Recommend recommend) {
        ConsoleWriter.printlnMessage("메뉴 추천 결과입니다.");
        ConsoleWriter.printlnMessage("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(recommend);
        printRecommends(coaches);
        ConsoleWriter.printlnMessage("추천을 완료했습니다.");
    }

    private void printCategories(Recommend recommend) {
        List<String> categories = recommend.getCategories();
        ConsoleWriter.printlnFormat("[ 카테고리 | %s ]", String.join(" | ", categories));
    }

    private void printRecommends(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            printRecommend(coach);
        }
    }

    private void printRecommend(Coach coach) {
        String result = coach.toString();
        ConsoleWriter.printlnFormat("[ %s | %s ]", coach.getName(), result);
    }
}
