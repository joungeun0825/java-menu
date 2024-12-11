package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
    private List<Coach> coaches;

    public Coaches() {
        coaches = new ArrayList<>();
    }

    public void add(String name) {
        Coach coach = new Coach(name);
        coaches.add(coach);
    }

    public List<Coach> getCoaches(){
        return this.coaches;
    }
}
