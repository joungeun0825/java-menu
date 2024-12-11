package menu.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    INVALID_INPUT_NAME_LENGTH_ERROR("잘못된 이름의 길이를 입력하였습니다."),
    INVALID_INPUT_LENGTH_ERROR("잘못된 명 수를 입력하였습니다."),
    INVALID_INPUT_MENU_ERROR("잘못된 메뉴를 입력하였습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}