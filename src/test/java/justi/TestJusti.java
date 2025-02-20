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

    @Before
    public void setup() {
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
        xtbLoginPage.login();
        xtbHomePage.printTrends();

       if (xtbHomePage.determineOverallTrend() == -1) {
           if (xtbHomePage.getOpenPositionType().equals(-1)) {
                System.out.println("Wskaźniki wskazały trend spadkowy ...");
                System.out.println("Pozycja sprzedaży była do tej pory otwarta ...");
                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
           }
       } else if (xtbHomePage.determineOverallTrend() == 0) {
           if (xtbHomePage.getOpenPositionType().equals(-1)) {
//                xtbHomePage.closePosition();
                System.out.println("Wskaźniki wskazały brak trendu ...");
                System.out.println("Pozycja sprzedaży była do tej pory otwarta ...");
                System.out.println("Pozycja sprzedaży została teraz zamknięta ...");
                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
           }
       } else if (xtbHomePage.determineOverallTrend() == 1) {
           if (xtbHomePage.getOpenPositionType().equals(-1)) {
//                xtbHomePage.closePosition();
//                xtbHomePage.openBuyPosition();
                System.out.println("Wskaźniki wskazały trend wzrostowy ...");
                System.out.println("Pozycja sprzedaży była do tej pory otwarta ...");
                System.out.println("Pozycja sprzedaży została teraz zamknięta ...");
                System.out.println("Pozycja kupna została teraz otwarta ...\n");
//            }
       } else if (xtbHomePage.determineOverallTrend() == -1) {
           if (xtbHomePage.getOpenPositionType().equals(0)) {
//                xtbHomePage.openSellPosition();
                System.out.println("Wskaźniki wskazały trend spadkowy ...");
                System.out.println("Żadna pozycja nie była do tej pory otwarta ...");
                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
                System.out.println("Pozycja sprzedaży została teraz otwarta ...\n");
//            }
       } else if (xtbHomePage.determineOverallTrend() == 0) {
           if (xtbHomePage.getOpenPositionType().equals(0)) {
                System.out.println("Wskaźniki wskazały brak trendu ...");
                System.out.println("Żadna pozycja nie była do tej pory otwarta ...");
                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
           }
       }
       if (xtbHomePage.determineOverallTrend() == 1) {
           if (xtbHomePage.getOpenPositionType().equals(0)) {
//                xtbHomePage.openBuyPosition();
                System.out.println("Wskaźniki wskazały trend wzrostowy ...");
                System.out.println("Żadna pozycja nie była do tej pory otwarta ...");
                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
                System.out.println("Pozycja kupna została teraz otwarta ...\n");
//            }
       } else if (xtbHomePage.determineOverallTrend() == -1) {
           if (xtbHomePage.getOpenPositionType().equals(1)) {
//                xtbHomePage.closePosition();
//                xtbHomePage.openSellPosition();
                System.out.println("Wskaźniki wskazały trend spadkowy ...");
                System.out.println("Pozycja kupna była do tej pory otwarta ...");
                System.out.println("Pozycja kupna została teraz zamknięta ...");
                System.out.println("Pozycja sprzedaży została teraz otwarta ...\n");
           }
       } else if (xtbHomePage.determineOverallTrend() == 0) {
           if (xtbHomePage.getOpenPositionType().equals(1)) {
//                xtbHomePage.closePosition();
                System.out.println("Wskaźniki wskazały brak trendu ...");
                System.out.println("Pozycja kupna była do tej pory otwarta ...");
                System.out.println("Pozycja kupna została teraz zamknięta ...");
           }
       }
       if (xtbHomePage.determineOverallTrend() == 1) {
           if (xtbHomePage.getOpenPositionType().equals(1)) {
            if (xtbHomePage.getOpenPositionType().equals(1)) {
                System.out.println("Wskaźniki wskazały trend wzrostowy ...");
                System.out.println("Pozycja kupna była do tej pory otwarta ...");
                System.out.println("Żadna pozycja nie została teraz zamknięta ...");
                System.out.println("Żadna pozycja nie została teraz otwarta ...\n");
           }
       }
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}