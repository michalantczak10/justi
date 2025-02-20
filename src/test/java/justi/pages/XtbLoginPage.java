package justi.pages;

import justi.reusable.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static justi.enums.ExpectedPageTitles.XTB_LOGIN_PAGE;

public class XtbLoginPage {

    WebDriver driver;
    Reusable reusable;
    By login = By.cssSelector("input[name='xslogin']");
    By password = By.cssSelector("input[name='xspass']");
    By loginButton = By.cssSelector("input[type='button']");

    public XtbLoginPage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusable(driver);
    }

    public void login() {
        reusable.openWebsite("https://xstation5.xtb.com/#/demo/loggedIn", XTB_LOGIN_PAGE.getExpectedPageTitle());
        reusable.waitForVisibilityAndSendKeysToElement(XTB_LOGIN_PAGE.getExpectedPageTitle(), login, "michalantczak@outlook.com");
        reusable.waitForVisibilityAndSendKeysToElement(XTB_LOGIN_PAGE.getExpectedPageTitle(), password, "Michal$170188!");
        reusable.waitForVisibilityOfElementAndClick(XTB_LOGIN_PAGE.getExpectedPageTitle(), loginButton);
    }
}