package justi.pages;

import justi.enums.ExpectedPageTitles;
import justi.reusable.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class XtbHomePage {
    WebDriver driver;
    Reusable reusable;
    By search = By.cssSelector("input[ng-model='searchString']");
    By sellButton = By.cssSelector("click-and-trade-button[id='clickAndTradeButtonBid']");
    By buyButton = By.cssSelector("click-and-trade-button[id='clickAndTradeButtonAsk']");
    By closeButton = By.cssSelector("span[data-xsot='ordersCloseTradeBtn']");
    By applyButton = By.cssSelector("button[class='applyBtn']");
    By openPosition = By.cssSelector("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div[5]/div/div/div/div[2]/div[1]/div");
    By positionType = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div[5]/div/div/div/div[2]/div[2]");

    public XtbHomePage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusable(driver);
    }

    public boolean isPositionIsOpen() {
        reusable.waitForPageTitle(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle());
        boolean positionOpened;
        try {
            reusable.waitForVisibilityOfElement(openPosition);
            positionOpened = true;
        } catch (Exception e) {
            positionOpened = false;
        }
        return positionOpened;
    }

    public Integer getOpenPositionType() {
        reusable.waitForPageTitle(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle());
        if (isPositionIsOpen()) {
            if (reusable.waitForVisibilityAndGetElementText(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), positionType).equals("Sell")) {
                return -1;
            } else if (reusable.waitForVisibilityAndGetElementText(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), positionType).equals("Buy")) {
                return 1;
            }
        }
        return 0;
    }

    public void openSellPosition() {
        reusable.waitForPageTitle(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle());
        reusable.waitForVisibilityAndSendKeysToElement(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), search, "LITECOIN");
        reusable.waitForVisibilityAndSendKeysToElement(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), search, String.valueOf(Keys.ENTER));
//        driver.findElement(search).sendKeys(Keys.ENTER);
        reusable.waitForVisibilityOfElementAndClick(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), sellButton);
        reusable.waitForVisibilityOfElementAndClick(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), applyButton);
    }

    public void openBuyPosition() {
        reusable.waitForPageTitle(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle());
        reusable.waitForVisibilityAndSendKeysToElement(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), search, "LITECOIN");
        reusable.waitForVisibilityAndSendKeysToElement(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), search, String.valueOf(Keys.ENTER));
//        driver.findElement(search).sendKeys(Keys.ENTER);
        reusable.waitForVisibilityOfElementAndClick(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), buyButton);
        reusable.waitForVisibilityOfElementAndClick(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), applyButton);

    }

    public void closePosition() {
        reusable.waitForPageTitle(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle());
        reusable.waitForVisibilityOfElementAndClick(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), closeButton);
//        justi.reusable.waitForVisibilityOfElement(popupConfirmTradeDraggable);
        reusable.waitForVisibilityOfElementAndClick(ExpectedPageTitles.XTB_HOME_PAGE.getExpectedPageTitle(), applyButton);

    }
}