package menu.domain;

import java.util.HashMap;
import java.util.Map;

public class Coaches {
    private Map<Coach, Menu> recommends;

    public Coaches() {
        recommends = new HashMap<>();
    }

    public void add(String name) {
        Coach coach = new Coach(name);
        recommends.put(coach, new Menu());
    }
}
