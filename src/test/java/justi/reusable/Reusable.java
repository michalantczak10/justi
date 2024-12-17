package justi.reusable;

import justi.enums.Parameters;
import justi.enums.ValidationMessages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Reusable {
    WebDriver driver;

    public Reusable(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite(String url, String expectedPageTitle) {
        try {
            driver.get(url);
            waitForPageTitle(expectedPageTitle);
        } catch (Exception e) {
            System.out.println(ValidationMessages.OPEN_WEBSITE_ERROR.getValidationMessage() + e.getMessage());
        }
    }

    public void waitForPageTitle(String expectedPageTitle) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Parameters.WAIT_TIME.getParameter()));
            wait.until(ExpectedConditions.titleIs(expectedPageTitle));
        } catch (TimeoutException e) {
            System.out.println(ValidationMessages.PAGE_VISIBILITY_ERROR.getValidationMessage() + e.getMessage());
        }
    }

    public void waitForVisibilityOfElement(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Parameters.WAIT_TIME.getParameter()));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            System.out.println(ValidationMessages.ELEMENT_VISIBITY_ERROR.getValidationMessage() + e.getMessage());
        }
    }

    public void clickElement(By element) {
        try {
            WebElement webElement = driver.findElement(element);
            webElement.click();
        } catch (NoSuchElementException e) {
            System.out.println(ValidationMessages.NOT_SUCH_ELEMENT_ERROR.getValidationMessage() + e.getMessage());
        }
    }

    public void waitForVisibilityOfElementAndClick(String expectedPageTitle, By element) {
        waitForPageTitle(expectedPageTitle);
        waitForVisibilityOfElement(element);
        clickElement(element);
    }

    public void waitForVisibilityAndSendKeysToElement(String expectedPageTitle, By element, String value) {
        waitForPageTitle(expectedPageTitle);
        waitForVisibilityOfElement(element);
        sendKeysToElement(element, value);
    }

    public void sendKeysToElement(By element, String symbolName) {
        try {
            driver.findElement(element).sendKeys(symbolName);
        } catch (NoSuchElementException e) {
            System.out.println(ValidationMessages.NOT_SUCH_ELEMENT_ERROR.getValidationMessage() + e.getMessage());
        }
    }

    public String waitForVisibilityAndGetElementText(String expectedPageTitle, By element) {
        waitForPageTitle(expectedPageTitle);
        waitForVisibilityOfElement(element);
        try {
            return driver.findElement(element).getText();
        } catch (NoSuchElementException e) {
            System.out.println(ValidationMessages.NOT_SUCH_ELEMENT_ERROR.getValidationMessage() + e.getMessage());
            return null;
        }
    }
}