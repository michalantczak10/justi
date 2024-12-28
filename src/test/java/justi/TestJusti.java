package justi;

import justi.pages.XtbHomePage;
import justi.pages.XtbLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static java.lang.Thread.sleep;

public class TestJusti {

    WebDriver driver;

    @Before
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
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
        System.out.println("Wskaźniki techniczne: ");
        System.out.println("RSI(14): " + xtbHomePage.checkRsiTrend());
        System.out.println("STOCH(9, 6): " + xtbHomePage.checkStochasticTrend());
        System.out.println("STOCHRSI(14): " + xtbHomePage.checkSrsiTrend());
        System.out.println("MACD(12, 26): " + xtbHomePage.checkMacdTrend());
        System.out.println("ADX(14): " + xtbHomePage.checkAdxTrend());
        System.out.println("Williams %R: " + xtbHomePage.checkWilliamsRTrend());
        System.out.println("CCI(14): " + xtbHomePage.checkCciTrend());
        System.out.println("ATR(14): " + xtbHomePage.checkAtrTrend());
        System.out.println("Wstęgi Bollingera(20, 2.5): " + xtbHomePage.checkBollingerBandsTrend());
        System.out.println("Acc: " + xtbHomePage.checkAccTrend());

        System.out.println("BULLS(13): " + xtbHomePage.checkBullsTrend());
        System.out.println("Średnie kroczące: ");
        System.out.println("Trend dla EMA: " + xtbHomePage.checkEmaTrend());


    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}