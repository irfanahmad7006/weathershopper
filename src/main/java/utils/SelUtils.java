package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelUtils {

    public static void explicitWaitClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void explicitWaitVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static void sendKey(WebDriver driver, By xpath, String value) {
        driver.findElement(xpath).sendKeys(value);
    }

    public static void slowTyping(WebDriver driver, By by, String value) {
        for (int i = 0; i < value.length(); i++) {
            driver.findElement(by).sendKeys(value.substring(i, i + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
