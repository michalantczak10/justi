package justi.enums;

public enum ValidationMessages {
    LOGIN_ERROR("Błąd podczas logowania: "),
    OPEN_WEBSITE_ERROR("Błąd otwarcia strony internetowej: "),
    PAGE_VISIBILITY_ERROR("Strona internetowa nie jest widoczna w trakcie wskazanego okresu czasu: "),
    ELEMENT_VISIBITY_ERROR("Element nie jest widoczny w trakcie wskazanego okresu czasu: "),
    NOT_SUCH_ELEMENT_ERROR("Element nie został odnaleziony: ");


    private final String ValidationMessage;

    ValidationMessages(String message) {
        this.ValidationMessage = message;
    }

    public String getValidationMessage() {
        return ValidationMessage;
    }
}