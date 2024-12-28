package justi.pages;

import justi.enums.Colors;
import justi.enums.Messages;
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
    public By ema10 = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'EMA [10, 0]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By ema20 = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'EMA [20, 0]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By ema50 = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'EMA [50, 0]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By ema100 = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'EMA [100, 0]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By ema200 = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'EMA [200, 0]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By rsi = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'RSI [14]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By macd = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'MACD [12, 26, 9]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By bollingerBands = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'Bollinger [20, 2.5]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By stochastic = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'SO [9, 6, 3]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By adx = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'ADX [14]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By cci = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'CCI [14]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By williamsR = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), '%R [15]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By srsi = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'SRSI [14]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By atr = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'ATR [14]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By bullsPower = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'Bulls [13]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By bearsPower = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'Bears [13]')]/following-sibling::span[@class='indicator-value-label ng-binding']");
    public By acc = By.xpath("//div[contains(@class, 'indicator-label-container')]//span[contains(text(), 'Acc')]/following-sibling::span[@class='indicator-value-label ng-binding']");


    public XtbHomePage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusable(driver);
    }

    public String checkEma5VsEma10Trend() {
        double ema5Value = Double.parseDouble(getIndicatorValue(ema5));
        double ema10Value = Double.parseDouble(getIndicatorValue(ema10));

        if (ema5Value > ema10Value) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (ema5Value < ema10Value) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkEma10VsEma20Trend() {
        double ema10Value = Double.parseDouble(getIndicatorValue(ema10));
        double ema20Value = Double.parseDouble(getIndicatorValue(ema20));

        if (ema10Value > ema20Value) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (ema10Value < ema20Value) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkEma20VsEma50Trend() {
        double ema20Value = Double.parseDouble(getIndicatorValue(ema20));
        double ema50Value = Double.parseDouble(getIndicatorValue(ema50));

        if (ema20Value > ema50Value) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (ema20Value < ema50Value) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkEma50VsEma100Trend() {
        double ema50Value = Double.parseDouble(getIndicatorValue(ema50));
        double ema100Value = Double.parseDouble(getIndicatorValue(ema100));

        if (ema50Value > ema100Value) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (ema50Value < ema100Value) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkEma100VsEma200Trend() {
        double ema100Value = Double.parseDouble(getIndicatorValue(ema100));
        double ema200Value = Double.parseDouble(getIndicatorValue(ema200));

        if (ema100Value > ema200Value) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (ema100Value < ema200Value) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkRsiTrend() {
        double rsiValue = Double.parseDouble(getIndicatorValue(rsi));

        if (rsiValue > 70) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (rsiValue < 30) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkMacdTrend() {
        String[] macdComponents = getIndicatorValue(macd).split(", ");
        double macdValue = Double.parseDouble(macdComponents[0]);
        double signalValue = Double.parseDouble(macdComponents[1]);

        if (macdValue > signalValue) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (macdValue < signalValue) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkBollingerBandsTrend() {
        String[] bollingerBandsComponents = getIndicatorValue(bollingerBands).split(", ");
        double upperBandValue = Double.parseDouble(bollingerBandsComponents[0]);
        double middleBandValue = Double.parseDouble(bollingerBandsComponents[1]);
        double lowerBandValue = Double.parseDouble(bollingerBandsComponents[2]);

        if (middleBandValue < lowerBandValue) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (middleBandValue > upperBandValue) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkStochasticTrend() {
        String[] stochasticComponents = getIndicatorValue(stochastic).split(", ");
        double stochasticMainValue = Double.parseDouble(stochasticComponents[0]);
        double stochasticSignalValue = Double.parseDouble(stochasticComponents[1]);

        if (stochasticMainValue > stochasticSignalValue && stochasticMainValue < 80) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (stochasticMainValue < stochasticSignalValue && stochasticMainValue > 20) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkAdxTrend() {
        String[] adxComponents = getIndicatorValue(adx).split(", ");
        double adxValue = Double.parseDouble(adxComponents[0]);
        double diPlusValue = Double.parseDouble(adxComponents[1]);
        double diMinusValue = Double.parseDouble(adxComponents[2]);

        if (diPlusValue > diMinusValue && adxValue > 25) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (diMinusValue > diPlusValue && adxValue > 25) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkCciTrend() {
        double cciValue = Double.parseDouble(getIndicatorValue(cci));

        if (cciValue > 100) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (cciValue < -100) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkWilliamsRTrend() {
        double williamsRValue = Double.parseDouble(getIndicatorValue(williamsR));

        if (williamsRValue > -20) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (williamsRValue < -80) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkSrsiTrend() {
        double srsiValue = Double.parseDouble(getIndicatorValue(srsi));

        if (srsiValue > 80) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (srsiValue < 20) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkAtrTrend() {
        double atrValue = Double.parseDouble(getIndicatorValue(atr));

        if (atrValue > 1.5) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (atrValue < 1.0) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkBullsTrend() {
        double bullsPowerValue = Double.parseDouble(getIndicatorValue(bullsPower));

        if (bullsPowerValue > 0) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (bullsPowerValue < 0) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkBearsTrend() {
        double bearsPowerValue = Double.parseDouble(getIndicatorValue(bearsPower));

        if (bearsPowerValue < 0) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (bearsPowerValue > 0) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String checkAccTrend() {
        double accValue = Double.parseDouble(getIndicatorValue(acc));

        if (accValue > 0) {
            return Colors.GREEN.getColor() + Messages.UPWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else if (accValue < 0) {
            return Colors.RED.getColor() + Messages.DOWNWARD_TREND.getMessage() + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + Messages.NO_CLEAR_TREND.getMessage() + Colors.RESET.getColor();
        }
    }

    public String getIndicatorValue(By indicator) {
        return reusable.waitForVisibilityAndGetElementText(XTB_HOME_PAGE.getExpectedPageTitle(), indicator);
    }

    public void printTrends() {
        System.out.println("Wskaźniki techniczne:");
        System.out.println("RSI(14): " + checkRsiTrend());
        System.out.println("STOCH(9, 6, 3): " + checkStochasticTrend());
        System.out.println("STOCHRSI(14): " + checkSrsiTrend());
        System.out.println("MACD(12, 26, 9): " + checkMacdTrend());
        System.out.println("ADX(14): " + checkAdxTrend());
        System.out.println("Williams %R: " + checkWilliamsRTrend());
        System.out.println("CCI(14): " + checkCciTrend());
        System.out.println("ATR(14): " + checkAtrTrend());
        System.out.println("Wstęgi Bollingera(20, 2.5): " + checkBollingerBandsTrend());
        System.out.println("Acc: " + checkAccTrend());
        System.out.println("BULLS(13): " + checkBullsTrend());
        System.out.println("BEARS(13): " + checkBearsTrend());
        System.out.println("Średnie kroczące:");
        System.out.println("EMA5 vs EMA10: " + checkEma5VsEma10Trend());
        System.out.println("EMA10 vs EMA20: " + checkEma10VsEma20Trend());
        System.out.println("EM20 vs EMA50: " + checkEma20VsEma50Trend());
        System.out.println("EM50 vs EMA100: " + checkEma50VsEma100Trend());
        System.out.println("EM50 vs EMA100: " + checkEma100VsEma200Trend());
    }

    public String determineOverallTrend() {
        int upwardTrendCount = 0;
        int downwardTrendCount = 0;
        int noClearTrendCount = 0;

        // Przykładowe wywołania metod do analizy trendów
        String[] trendResults = {
                checkRsiTrend(),
                checkStochasticTrend(),
                checkSrsiTrend(),
                checkMacdTrend(),
                checkAdxTrend(),
                checkWilliamsRTrend(),
                checkCciTrend(),
                checkAtrTrend(),
                checkBollingerBandsTrend(),
                checkAccTrend(),
                checkBullsTrend(),
                checkBearsTrend(),
                checkEma5VsEma10Trend(),
                checkEma10VsEma20Trend(),
                checkEma20VsEma50Trend(),
                checkEma50VsEma100Trend(),
                checkEma100VsEma200Trend()
        };

        // Analiza wyników
        for (String trend : trendResults) {
            if (trend.contains(Messages.UPWARD_TREND.getMessage())) {
                upwardTrendCount++;
            } else if (trend.contains(Messages.DOWNWARD_TREND.getMessage())) {
                downwardTrendCount++;
            } else {
                noClearTrendCount++;
            }
        }

        // Wyznaczanie ostatecznego trendu
        if (upwardTrendCount > downwardTrendCount && upwardTrendCount > noClearTrendCount) {
            return Colors.GREEN.getColor() + "Ostateczny trend: Wzrostowy" + Colors.RESET.getColor();
        } else if (downwardTrendCount > upwardTrendCount && downwardTrendCount > noClearTrendCount) {
            return Colors.RED.getColor() + "Ostateczny trend: Spadkowy" + Colors.RESET.getColor();
        } else {
            return Colors.WHITE.getColor() + "Ostateczny trend: Brak wyraźnego trendu" + Colors.RESET.getColor();
        }
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