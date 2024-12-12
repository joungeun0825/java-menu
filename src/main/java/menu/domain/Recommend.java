package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.constant.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recommend {
    private List<String> categories;

    public Recommend() {
        categories = new ArrayList<>();
    }

    public void addCategory(String category) {
        this.categories.add(category);
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public String recommendCategory() {
        return Category.getCategoryFromIndex(Randoms.pickNumberInRange(1, 5));
    }
}
