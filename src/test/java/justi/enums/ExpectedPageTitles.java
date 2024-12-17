package justi.enums;

public enum ExpectedPageTitles {
    XTB_LOGIN_PAGE("xStation 5 - XTB Online Investing Platform"),
    XTB_HOME_PAGE("xStation 5");

    private final String ExpectedPageTitle;

    ExpectedPageTitles(String title) {
        this.ExpectedPageTitle = title;
    }

    public String getExpectedPageTitle() {
        return ExpectedPageTitle;
    }
}