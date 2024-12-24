package justi.enums;

public enum Messages {
    STRONG_UPWARD_TREND("Silny trend wzrostowy"),
    UPWARD_TREND("Trend wzrostowy"),
    NO_CLEAR_TREND("Brak wyraźnego trendu"),
    DOWNWARD_TREND("Trend spadkowy"),
    STRONG_DOWNWARD_TREND("Silny trend spadkowy");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}