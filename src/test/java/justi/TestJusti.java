package justi;

import justi.pages.XtbHomePage;
import justi.pages.XtbLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestJusti {

    WebDriver driver;

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testJusti() {
        XtbLoginPage xtbLoginPage = new XtbLoginPage(driver);
        XtbHomePage xtbHomePage = new XtbHomePage(driver);
        tradeStrategy(xtbLoginPage, xtbHomePage);
        quitDriver();
    }

    public void tradeStrategy(XtbLoginPage xtbLoginPage, XtbHomePage xtbHomePage) {
        try {
            xtbLoginPage.login();
            printTrends(xtbHomePage);
            // Dodaj tutaj logikę handlową
        } catch (Exception e) {
            e.printStackTrace();
        }


//        if (investingPage.getIndicatorsStateSummary().equals(-1)) {
//            if (xtbHomePage.getOpenPositionType().equals(-1)) {
//                System.out.println("Wskaźniki wskazały trend spadkowy ...");
//                System.out.println("Pozycja sprzedaży była do tej pory otwarta ...");
//                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
//                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
//            }
//        } else if (investingPage.getIndicatorsStateSummary().equals(0)) {
//            if (xtbHomePage.getOpenPositionType().equals(-1)) {
////                xtbHomePage.closePosition();
//                System.out.println("Wskaźniki wskazały brak trendu ...");
//                System.out.println("Pozycja sprzedaży była do tej pory otwarta ...");
//                System.out.println("Pozycja sprzedaży została teraz zamknięta ...");
//                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
//            }
//        } else if (investingPage.getIndicatorsStateSummary().equals(1)) {
//            if (xtbHomePage.getOpenPositionType().equals(-1)) {
////                xtbHomePage.closePosition();
////                xtbHomePage.openBuyPosition();
//                System.out.println("Wskaźniki wskazały trend wzrostowy ...");
//                System.out.println("Pozycja sprzedaży była do tej pory otwarta ...");
//                System.out.println("Pozycja sprzedaży została teraz zamknięta ...");
//                System.out.println("Pozycja kupna została teraz otwarta ...\n");
//            }
//        } else if (investingPage.getIndicatorsStateSummary().equals(-1)) {
//            if (xtbHomePage.getOpenPositionType().equals(0)) {
////                xtbHomePage.openSellPosition();
//                System.out.println("Wskaźniki wskazały trend spadkowy ...");
//                System.out.println("Żadna pozycja nie była do tej pory otwarta ...");
//                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
//                System.out.println("Pozycja sprzedaży została teraz otwarta ...\n");
//            }
//        } else if (investingPage.getIndicatorsStateSummary().equals(0)) {
//            if (xtbHomePage.getOpenPositionType().equals(0)) {
//                System.out.println("Wskaźniki wskazały brak trendu ...");
//                System.out.println("Żadna pozycja nie była do tej pory otwarta ...");
//                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
//                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
//            }
//        } else if (investingPage.getIndicatorsStateSummary().equals(1)) {
//            if (xtbHomePage.getOpenPositionType().equals(0)) {
////                xtbHomePage.openBuyPosition();
//                System.out.println("Wskaźniki wskazały trend wzrostowy ...");
//                System.out.println("Żadna pozycja nie była do tej pory otwarta ...");
//                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
//                System.out.println("Pozycja kupna została teraz otwarta ...\n");
//            }
//        } else if (investingPage.getIndicatorsStateSummary().equals(-1)) {
//            if (xtbHomePage.getOpenPositionType().equals(1)) {
////                xtbHomePage.closePosition();
////                xtbHomePage.openSellPosition();
//                System.out.println("Wskaźniki wskazały trend spadkowy ...");
//                System.out.println("Pozycja kupna była do tej pory otwarta ...");
//                System.out.println("Pozycja kupna została teraz zamknięta ...");
//                System.out.println("Pozycja sprzedaży została teraz otwarta ...\n");
//            }
//        } else if (investingPage.getIndicatorsStateSummary().equals(0)) {
//            if (xtbHomePage.getOpenPositionType().equals(1)) {
////                xtbHomePage.closePosition();
//                System.out.println("Wskaźniki wskazały brak trendu ...");
//                System.out.println("Pozycja kupna była do tej pory otwarta ...");
//                System.out.println("Pozycja kupna została teraz zamknięta ...");
//                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
//            }
//        } else if (investingPage.getIndicatorsStateSummary().equals(1)) {
//            if (xtbHomePage.getOpenPositionType().equals(1)) {
//                System.out.println("Wskaźniki wskazały trend wzrostowy ...");
//                System.out.println("Pozycja kupna była do tej pory otwarta ...");
//                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
//                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
//            }
//        }
    }

    public void printTrends(XtbHomePage xtbHomePage) {
        System.out.println("Trend dla EMA: " + xtbHomePage.checkEmaTrend());
        System.out.println("Trend dla RSI: " + xtbHomePage.checkRsiTrend());
        System.out.println("Trend dla MACD: " + xtbHomePage.checkMacdTrend());
        System.out.println("Trend dla Wstęg Bollingera: " + xtbHomePage.checkBollingerBandsTrend());
        System.out.println("Trend dla Oscylatora Stochastycznego: " + xtbHomePage.checkStochasticTrend());
        System.out.println("Trend dla ADX: " + xtbHomePage.checkAdxTrend());
        System.out.println("Trend dla CCI: " + xtbHomePage.checkCciTrend());
        System.out.println("Trend dla Williams %R: " + xtbHomePage.checkWilliamsRTrend());
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}