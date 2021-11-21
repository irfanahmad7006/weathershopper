package stepdefs;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import weatherShopPages.BuyProductsPage;

public class BuyProductsStepDefs {
    private BuyProductsPage buyProductsPage = new BuyProductsPage(DriverFactory.getDriver());
    private int noOfProductSelected = 0;

    @When("User clicks on add for cheapest the product")
    public void user_clicks_on_add_cheapest_the_product() {
        buyProductsPage.findCheapestProduct();
        buyProductsPage.clickOnAddBtn();
        noOfProductSelected++;
    }

    @Given("User clicks on add for cheapest the products as per the info icon")
    public void user_clicks_on_add_for_cheapest_the_product_as_per_the_info_icon() {
        if (buyProductsPage.getHeading().equalsIgnoreCase("Moisturizers")){
            buyProductsPage.findCheapestAleo();
            buyProductsPage.clickOnAddBtn();
            noOfProductSelected++;
            buyProductsPage.findCheapestAlmond();
            buyProductsPage.clickOnAddBtn();
            noOfProductSelected++;
        }else {
            buyProductsPage.findCheapestSPF50();
            buyProductsPage.clickOnAddBtn();
            noOfProductSelected++;
            buyProductsPage.findCheapestSPF30();
            buyProductsPage.clickOnAddBtn();
            noOfProductSelected++;
        }
    }

    @When("User clicks on add for expensive the product")
    public void user_clicks_on_add_for_expensive_the_product() {
        buyProductsPage.findExpensiveProduct();
        buyProductsPage.clickOnAddBtn();
        noOfProductSelected++;
    }

    @Then("Product should add to the cart")
    public void product_should_add_to_the_cart() {
        int actualNumItems = buyProductsPage.getNumOfItems();
        Assert.assertEquals(noOfProductSelected, actualNumItems);
    }

    @When("User click on the cart button")
    public void user_click_on_the_cart_button() {
        buyProductsPage.clickCartButton();
    }
}
