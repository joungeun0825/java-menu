package menu.domain;

import menu.domain.constant.Menu;

import java.util.List;

public class Coach {
    private String name;
    private List<Menu> exceptMenus;

    public Coach(String name) {
        this.name = name;
    }

    public void updateExceptMenus(List<Menu> exceptMenus){
        this.exceptMenus = exceptMenus;
    }

    public String getName() {
        return this.name;
    }
}
