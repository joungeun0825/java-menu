package menu.domain.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Category {
    일식(1), 한식(2), 중식(3), 아시안(4), 양식(5);

    private final int index;

    Category(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public static String getCategoryFromIndex(int index) {
        return Arrays.stream(Category.values())
                .filter(element -> element.getIndex() == index)
                .map(Enum::name)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 인덱스에 해당하는 카테고리가 없습니다."));
    }
}
