package weatherShopPages;

import utils.SelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyProductsPage {
    private WebDriver driver;
    private By heading = By.xpath("//h2");
    private By productList = By.xpath("//div[@class='container']/div");
    private By productPrice = By.xpath("//p[contains(text(),'Price')]");
    private By cartButtonText = By.xpath("//button[@onclick='goToCart()']/span");
    private By cartButton = By.xpath("//button[@onclick='goToCart()']");
    private String dynamicCheapXPath ="";
    //Moist
    private By aleoPrice = By.xpath("//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'aloe')]//following-sibling::p");
    private By almondPrice = By.xpath("//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'almond')]//following-sibling::p");
    //Sunscreens
    private By spf50Price = By.xpath("//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'spf-50')]//following-sibling::p");
    static By spf30Price = By.xpath("//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'spf-30')]//following-sibling::p");

    public BuyProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findCheapestSPF50(){
        WebElement elem = null;
        SelUtils.explicitWaitVisible(driver, productList);
        List<WebElement> sPF50PriceList = driver.findElements(spf50Price);
        Map<WebElement, Integer> mapSPF50 = new HashMap<>();
        for (WebElement ele : sPF50PriceList) {
            String price = ele.getText();
            String priceSplit[] = price.split(" ");
            int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
            System.out.println(price);
            mapSPF50.put(ele, priceInInt);
        }
        int min = Collections.min(mapSPF50.values());
        for (Map.Entry<WebElement, Integer> entry : mapSPF50.entrySet()) {
            if (entry.getValue() == min) {
                elem = entry.getKey();
                break;
            }
        }
        dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
        System.out.println("Cheapest sunscreen "+driver.findElement(heading).getText()+" with SPF-50 xpath created: "+ dynamicCheapXPath);
    }

    public void findCheapestSPF30(){
        WebElement elem = null;
        SelUtils.explicitWaitVisible(driver, productList);
        List<WebElement> sPF30PriceList = driver.findElements(spf30Price);
        Map<WebElement, Integer> mapSPF30 = new HashMap<>();
        for (WebElement ele : sPF30PriceList) {
            String price = ele.getText();
            String priceSplit[] = price.split(" ");
            int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
            System.out.println(price);
            mapSPF30.put(ele, priceInInt);
        }
        int min = Collections.min(mapSPF30.values());
        for (Map.Entry<WebElement, Integer> entry : mapSPF30.entrySet()) {
            if (entry.getValue() == min) {
                elem = entry.getKey();
                break;
            }
        }
        dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
        System.out.println("Cheapest sunscreen "+driver.findElement(heading).getText()+" with SPF-30 xpath created: "+ dynamicCheapXPath);

    }

    public void findCheapestAleo(){
        WebElement elem = null;
        SelUtils.explicitWaitVisible(driver, productList);
        List<WebElement> priceList = driver.findElements(aleoPrice);
        Map<WebElement, Integer> map = new HashMap<>();
        for (WebElement ele : priceList) {
            String price = ele.getText();
            String priceSplit[] = price.split(" ");
            int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
            System.out.println(price);
            map.put(ele, priceInInt);
        }
        int min = Collections.min(map.values());
        for (Map.Entry<WebElement, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                elem = entry.getKey();
                break;
            }
        }
        dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
        System.out.println("Cheapest "+driver.findElement(heading).getText()+" with Aloe xpath created: "+ dynamicCheapXPath);
    }


    public void findCheapestAlmond(){
        WebElement elem = null;
        SelUtils.explicitWaitVisible(driver, productList);
        List<WebElement> priceList = driver.findElements(almondPrice);
        Map<WebElement, Integer> map = new HashMap<>();
        for (WebElement ele : priceList) {
            String price = ele.getText();
            String priceSplit[] = price.split(" ");
            int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
            System.out.println(price);
            map.put(ele, priceInInt);
        }
        int min = Collections.min(map.values());
        for (Map.Entry<WebElement, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                elem = entry.getKey();
                break;
            }
        }
        dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
        System.out.println("Cheapest "+driver.findElement(heading).getText()+" with Almond xpath created: "+ dynamicCheapXPath);
    }



    public String getHeading(){
        return driver.findElement(heading).getText();
    }

    public void findCheapestProduct() {
        WebElement elem = null;
        SelUtils.explicitWaitVisible(driver, productList);
        List<WebElement> sPF50PriceList = driver.findElements(productPrice);
        Map<WebElement, Integer> priceList = new HashMap<>();
        for (WebElement ele : sPF50PriceList) {
            String price = ele.getText();
            String priceSplit[] = price.split(" ");
            int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
            System.out.println(price);
            priceList.put(ele, priceInInt);
        }

        int min = Collections.min(priceList.values());
        for (Map.Entry<WebElement, Integer> entry : priceList.entrySet()) {
            if (entry.getValue() == min) {
                elem = entry.getKey();
                break;
            }
        }
        dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
        System.out.println("Cheapest "+driver.findElement(heading).getText()+" xpath created: "+ dynamicCheapXPath);
    }

    public void findExpensiveProduct(){
        WebElement elem = null;
        SelUtils.explicitWaitVisible(driver, productList);
        List<WebElement> sPF50PriceList = driver.findElements(productPrice);
        Map<WebElement, Integer> priceList = new HashMap<>();
        for (WebElement ele : sPF50PriceList) {
            String price = ele.getText();
            String priceSplit[] = price.split(" ");
            int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
            System.out.println(price);
            priceList.put(ele, priceInInt);
        }

        int max = Collections.max(priceList.values());
        for (Map.Entry<WebElement, Integer> entry : priceList.entrySet()) {
            if (entry.getValue() == max) {
                elem = entry.getKey();
                break;
            }
        }
        dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + max + "')]//following-sibling::button";
        System.out.println("Expensive "+driver.findElement(heading).getText()+" xpath created: "+ dynamicCheapXPath);
    }



    public void clickOnAddBtn() {
        driver.findElement(By.xpath(dynamicCheapXPath)).click();
    }

    public int getNumOfItems() {
        SelUtils.explicitWaitClickable(driver, cartButtonText);
        String items = driver.findElement(cartButtonText).getText();
        String[] let = items.split(" ");
        int _item = Integer.parseInt(let[0]);
        return _item;
    }

    public void clickCartButton(){
        SelUtils.explicitWaitClickable(driver,cartButton);
        driver.findElement(cartButton).click();
    }
}