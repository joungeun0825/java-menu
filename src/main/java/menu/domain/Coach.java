package menu.domain;

import menu.domain.constant.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private String name;
    private List<Menu> exceptMenus;
    private List<String> recommend;

    public Coach(String name) {
        this.name = name;
        this.exceptMenus = new ArrayList<>();
        this.recommend = new ArrayList<>();
    }

    public void updateExceptMenus(List<Menu> exceptMenus) {
        this.exceptMenus = exceptMenus;
    }

    public void updateRecommend(String menu) {
        this.recommend.add(menu);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getRecommend() {
        return this.recommend;
    }

    public List<Menu> getExceptMenus() {
        return this.exceptMenus;
    }

    @Override
    public String toString(){
        List<String> recommends = this.recommend
                .stream()
                .collect(Collectors.toList());
        return String.join(" | ", recommends);
    }
}
