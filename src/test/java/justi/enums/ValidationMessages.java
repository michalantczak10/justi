package justi.enums;

public enum ValidationMessages {
    LOGIN_ERROR("Błąd podczas logowania."),
    OPEN_WEBSITE_ERROR("Błąd otwarcia strony internetowej."),
    PAGE_VISIBILITY_ERROR("Strona internetowa nie jest widoczna."),
    ELEMENT_VISIBITY_ERROR("Element nie jest widoczny."),
    NOT_SUCH_ELEMENT_ERROR("Element nie został odnaleziony.");

    private final String validationMessage;

    ValidationMessages(String message) {
        this.validationMessage = message;
    }

    public String getValidationMessage() {
        return validationMessage;
    }
}