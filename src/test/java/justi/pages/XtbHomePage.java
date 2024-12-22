package justi.pages;

import justi.reusable.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static justi.enums.ExpectedPageTitles.XTB_HOME_PAGE;

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
    public By ema5 = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'EMA [5, 0]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By ema20 = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'EMA [20, 0]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By rsi = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'RSI [14]')]/following-sibling::span[@class='indicator-value-label ng-binding']");


    public XtbHomePage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusable(driver);
    }


    public String checkEMATrend() {
        if (getIndicatorValue(ema5) > getIndicatorValue(ema20)) {
            return "Trend wzrostowy";
        }
        else if (getIndicatorValue(ema5) < getIndicatorValue(ema20)) {
            return "Trend spadkowy";
        }
        else {
            return "Brak wyraźnego trendu";
        }
    }

    public String checkRSITrend() {
        if (getIndicatorValue(rsi) > 70) {
            return "Wskaźnik RSI wskazuje na wykupienie (trend spadkowy)";
        } else if (getIndicatorValue(rsi) < 30) {
            return "Wskaźnik RSI wskazuje na wyprzedanie (trend wzrostowy)";
        } else {
            return "Wskaźnik RSI wskazuje na neutralny trend";
        }
    }


    public double getIndicatorValue(By indicator) {
        return Double.parseDouble(reusable.waitForVisibilityAndGetElementText(XTB_HOME_PAGE.getExpectedPageTitle(), indicator));
    }

    public boolean isPositionIsOpen() {
        reusable.waitForPageTitle(XTB_HOME_PAGE.getExpectedPageTitle());
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
        reusable.waitForPageTitle(XTB_HOME_PAGE.getExpectedPageTitle());
        if (isPositionIsOpen()) {
            if (reusable.waitForVisibilityAndGetElementText(XTB_HOME_PAGE.getExpectedPageTitle(), positionType).equals("Sell")) {
                return -1;
            } else if (reusable.waitForVisibilityAndGetElementText(XTB_HOME_PAGE.getExpectedPageTitle(), positionType).equals("Buy")) {
                return 1;
            }
        }
        return 0;
    }

    public void openSellPosition() {
        reusable.waitForPageTitle(XTB_HOME_PAGE.getExpectedPageTitle());
        reusable.waitForVisibilityAndSendKeysToElement(XTB_HOME_PAGE.getExpectedPageTitle(), search, "LITECOIN");
        reusable.waitForVisibilityAndSendKeysToElement(XTB_HOME_PAGE.getExpectedPageTitle(), search, String.valueOf(Keys.ENTER));
//        driver.findElement(search).sendKeys(Keys.ENTER);
        reusable.waitForVisibilityOfElementAndClick(XTB_HOME_PAGE.getExpectedPageTitle(), sellButton);
        reusable.waitForVisibilityOfElementAndClick(XTB_HOME_PAGE.getExpectedPageTitle(), applyButton);
    }

    public void openBuyPosition() {
        reusable.waitForPageTitle(XTB_HOME_PAGE.getExpectedPageTitle());
        reusable.waitForVisibilityAndSendKeysToElement(XTB_HOME_PAGE.getExpectedPageTitle(), search, "LITECOIN");
        reusable.waitForVisibilityAndSendKeysToElement(XTB_HOME_PAGE.getExpectedPageTitle(), search, String.valueOf(Keys.ENTER));
//        driver.findElement(search).sendKeys(Keys.ENTER);
        reusable.waitForVisibilityOfElementAndClick(XTB_HOME_PAGE.getExpectedPageTitle(), buyButton);
        reusable.waitForVisibilityOfElementAndClick(XTB_HOME_PAGE.getExpectedPageTitle(), applyButton);

    }

    public void closePosition() {
        reusable.waitForPageTitle(XTB_HOME_PAGE.getExpectedPageTitle());
        reusable.waitForVisibilityOfElementAndClick(XTB_HOME_PAGE.getExpectedPageTitle(), closeButton);
//        justi.reusable.waitForVisibilityOfElement(popupConfirmTradeDraggable);
        reusable.waitForVisibilityOfElementAndClick(XTB_HOME_PAGE.getExpectedPageTitle(), applyButton);

    }
}