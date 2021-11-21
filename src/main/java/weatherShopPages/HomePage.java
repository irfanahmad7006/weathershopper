package weatherShopPages;

import utils.SelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By temp = By.xpath("//span[@id='temperature']");
    static By buySunscreenBtn = By.xpath("//button[normalize-space()='Buy sunscreens']");
    static By buyMoistBtn = By.xpath("//button[contains(text(),'Buy moisturizers')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public int getTemp() {
        SelUtils.explicitWaitVisible(driver, temp);
        String liveTemp = driver.findElement(temp).getText();
        String[] let = liveTemp.split(" ");
        int tempInInt = Integer.parseInt(let[0]);
        return tempInInt;
    }

    public void clickOnMoist() {
        SelUtils.explicitWaitClickable(driver, buyMoistBtn);
        driver.findElement(buyMoistBtn).click();
    }

    public void clickOnSunscrn() {
        SelUtils.explicitWaitClickable(driver, buySunscreenBtn);
        driver.findElement(buySunscreenBtn).click();
    }
}
