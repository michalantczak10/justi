package justi.pages;

import justi.reusable.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static justi.TestJusti.*;
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
    public By macd = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'MACD [12, 26, 9]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By bollingerBands = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'Bollinger [20, 2.5]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By stochastic = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'SO [9, 6, 3]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By adx = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'ADX [14]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By cci = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'CCI [14]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By williamsR = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), '%R [15]')]/following-sibling::span[@class='indicator-value-label ng-binding']");

    public XtbHomePage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusable(driver);
    }

    public String checkEmaTrend() {
        if (Double.parseDouble(getIndicatorValue(ema5)) > Double.parseDouble(getIndicatorValue(ema20))) {
            return GREEN + "Trend wzrostowy" + RESET;
        } else if (Double.parseDouble(getIndicatorValue(ema5)) < Double.parseDouble(getIndicatorValue(ema20))) {
            return RED + "Trend spadkowy" + RESET;
        } else {
            return "Brak wyraźnego trendu";
        }
    }

    public String checkRsiTrend() {
        if (Double.parseDouble(getIndicatorValue(rsi)) > 70) {
            return "Trend spadkowy";
        } else if (Double.parseDouble(getIndicatorValue(rsi)) < 30) {
            return "Trend wzrostowy";
        } else {
            return "Brak wyraźnego trendu";
        }
    }

    public String checkMacdTrend() {
        String[] partsMACD = getIndicatorValue(macd).split(", ");
        String macdValue = partsMACD[0];
        String macdSignal = partsMACD[1];

        if (Double.parseDouble(macdValue) > Double.parseDouble(macdSignal)) {
            return "Trend wzrostowy";
        } else if (Double.parseDouble(macdValue) < Double.parseDouble(macdSignal)) {
            return "Trend spadkowy";
        } else {
            return "Brak wyraźnego trendu";
        }
    }

    public String checkBollingerBandsTrend() {
        String[] partsBollingerBands = getIndicatorValue(bollingerBands).split(", ");
        String bollingerBandsUpperBand = partsBollingerBands[0];
        String bollingerBandsMiddleBand = partsBollingerBands[1];
        String bollingerBandsLowerBand = partsBollingerBands[2];

        if (Double.parseDouble(bollingerBandsMiddleBand) < Double.parseDouble(bollingerBandsLowerBand)) {
            return "Trend spadkowy";
        } else if (Double.parseDouble(bollingerBandsMiddleBand) > Double.parseDouble(bollingerBandsUpperBand)) {
            return "Trend wzrostowy";
        } else {
            return "Brak wyraźnego trendu";
        }
    }

    public String checkStochasticTrend() {
        String[] partsStochastic = getIndicatorValue(stochastic).split(", ");
        String stochasticMain = partsStochastic[0];
        String stochasticSignal = partsStochastic[1];

        if (Double.parseDouble(stochasticMain) > Double.parseDouble(stochasticSignal) && Double.parseDouble(stochasticMain) < 80) {
            return "Trend wzrostowy";
        } else if (Double.parseDouble(stochasticMain) < Double.parseDouble(stochasticSignal) && Double.parseDouble(stochasticMain) > 20) {
            return "Trend spadkowy";
        } else {
            return "Brak wyraźnego trendu";
        }
    }

    public String checkAdxTrend() {
        String[] partsAdx = getIndicatorValue(adx).split(", ");
        String adx = partsAdx[0];
        String diPlus = partsAdx[1];
        String diMinus = partsAdx[2];

        if (Double.parseDouble(adx) > 25) {
            if (Double.parseDouble(diPlus) > Double.parseDouble(diMinus)) {
                return "Silny trend wzrostowy";
            } else if (Double.parseDouble(diMinus) > Double.parseDouble(diPlus)) {
                return "Silny trend spadkowy";
            } else {
                return "Silny trend, ale brak wyraźnego kierunku";
            }
        } else {
            return "Słaby trend lub brak trendu";
        }
    }

    public String checkCciTrend() {
        if (Double.parseDouble(getIndicatorValue(cci)) > 100) {
            return "Trend spadkowy";
        } else if (Double.parseDouble(getIndicatorValue(cci)) < -100) {
            return "Trend wzrostowy";
        } else {
            return "Brak wyraźnego trendu";
        }
    }

    public String checkWilliamsRTrend() {
        if (Double.parseDouble(getIndicatorValue(williamsR)) > -20) {
            return "Trend spadkowy";
        } else if (Double.parseDouble(getIndicatorValue(williamsR)) < -80) {
            return "Trend wzrostowy";
        } else {
            return "Brak wyraźnego trendu";
        }
    }

    public String getIndicatorValue(By indicator) {
        return reusable.waitForVisibilityAndGetElementText(XTB_HOME_PAGE.getExpectedPageTitle(), indicator);
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
        reusable.waitForVisibilityAndSendKeysToElement(XTB_HOME_PAGE.getExpectedPageTitle(), search, "SOLANA");
        reusable.waitForVisibilityAndSendKeysToElement(XTB_HOME_PAGE.getExpectedPageTitle(), search, String.valueOf(Keys.ENTER));
//        driver.findElement(search).sendKeys(Keys.ENTER);
        reusable.waitForVisibilityOfElementAndClick(XTB_HOME_PAGE.getExpectedPageTitle(), sellButton);
        reusable.waitForVisibilityOfElementAndClick(XTB_HOME_PAGE.getExpectedPageTitle(), applyButton);
    }

    public void openBuyPosition() {
        reusable.waitForPageTitle(XTB_HOME_PAGE.getExpectedPageTitle());
        reusable.waitForVisibilityAndSendKeysToElement(XTB_HOME_PAGE.getExpectedPageTitle(), search, "SOLANA");
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