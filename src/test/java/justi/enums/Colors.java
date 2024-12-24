package justi.enums;

public enum Colors {
    GREEN("\u001B[32m"),
    RED("\u001B[31m"),
    WHITE("\u001B[37m"),
    RESET("\u001B[0m");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}