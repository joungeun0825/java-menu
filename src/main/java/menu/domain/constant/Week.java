package menu.domain.constant;

public enum Week {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    THURSDAY("수요일"),
    WEDNESDAY("목요일"),
    FRIDAY("금요일");

    private final String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
