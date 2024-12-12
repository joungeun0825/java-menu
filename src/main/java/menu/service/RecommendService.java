package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommend;
import menu.domain.constant.Category;
import menu.domain.constant.Menu;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecommendService {
    public static void recommend(Recommend recommend, Coaches coaches) {
        String recommendedCategory = recommendCategory(recommend);
        for (Coach coach : coaches.getCoaches()) {
            recommendMenu(coach, recommendedCategory);
        }
    }

    private static String recommendCategory(Recommend recommend) {
        String category;
        while (true) {
            category = recommend.recommendCategory();
            if (Collections.frequency(recommend.getCategories(), category) < 2) {
                break;
            }
        }
        recommend.addCategory(category);
        return category;
    }

    private static void recommendMenu(Coach coach, String category) {
        List<String> menus = Menu.getMenusFromCategory(category);

        String menu;
        while (true) {
            menu = Randoms.shuffle(menus).get(0);
            if (!coach.getRecommend().contains(menu) && !coach.getExceptMenus().contains(menu)) {
                break;
            }
        }
        coach.updateRecommend(menu);
    }
}
