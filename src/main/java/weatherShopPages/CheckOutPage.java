package weatherShopPages;

import org.openqa.selenium.WebElement;
import utils.SelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckOutPage {
    private WebDriver driver;
    private By checkHeading = By.xpath("//h2");
    private By productName = By.xpath("//td[1]");
    private By payWithCard = By.xpath("//span[contains(text(),'Pay with Card')]");
    private By checkForm = By.xpath("//div[@class='bodyView']");
    private By email = By.xpath("//input[@id='email']");
    private By cardNum = By.xpath("//input[@id='card_number']");
    private By expiryDate = By.xpath("//input[@id='cc-exp']");
    private By cvv = By.xpath("//input[@id='cc-csc']");
    private By zip = By.xpath("//input[@id='billing-zip']");
    private By payBtn = By.xpath("//span[@class='iconTick']");
    private By paymentSuccessful = By.xpath("//h2[contains(text(),'PAYMENT SUCCESS')]");
    private By paymentUnSuccessful = By.xpath("//h2[contains(text(),'PAYMENT FAILED')]");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isOnCheckOutPage() {

        SelUtils.explicitWaitVisible(driver, checkHeading);
        return driver.findElement(checkHeading).isDisplayed();
    }

    public List<WebElement> getProductNames() {
        SelUtils.explicitWaitVisible(driver, productName);
        return driver.findElements(productName);
    }

    public void clickOnPayLink() {
        SelUtils.explicitWaitVisible(driver, payWithCard);
        driver.findElement(payWithCard).click();
    }

    public boolean checkOutFormDisplayed() {
        driver.switchTo().frame(0);
        SelUtils.explicitWaitVisible(driver, checkForm);
        return driver.findElement(checkForm).isDisplayed();
    }

    public void enterCardDetail(List list) {
        SelUtils.explicitWaitClickable(driver, email);
        SelUtils.explicitWaitClickable(driver, cardNum);
        SelUtils.explicitWaitClickable(driver, expiryDate);
        SelUtils.explicitWaitClickable(driver, cvv);
        SelUtils.sendKey(driver, email, list.get(0).toString());
        SelUtils.slowTyping(driver, cardNum, list.get(1).toString());
        SelUtils.slowTyping(driver, expiryDate, list.get(2).toString());
        SelUtils.slowTyping(driver, cvv, list.get(3).toString());
        SelUtils.explicitWaitVisible(driver, zip);
        SelUtils.sendKey(driver, zip, list.get(4).toString());
    }

    public void clickOnPayBtn() {
        SelUtils.explicitWaitClickable(driver, payBtn);
        driver.findElement(payBtn).click();
    }


    public String getPaymentConfirmation(){
        try {
            SelUtils.explicitWaitVisible(driver, paymentSuccessful);
            return driver.findElement(paymentSuccessful).getText();
        } catch (Exception e) {
            SelUtils.explicitWaitVisible(driver, paymentUnSuccessful);
            return driver.findElement(paymentUnSuccessful).getText();
        }

    }

}
