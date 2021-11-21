package stepdefs;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import weatherShopPages.CheckOutPage;

import java.util.List;

public class CheckOutStepDefs {
    private CheckOutPage checkout = new CheckOutPage(DriverFactory.getDriver());

    @Then("User should navigate to checkout page")
    public void user_should_navigate_to_checkout_page() {
        Assert.assertTrue(checkout.isOnCheckOutPage());
    }

    @Then("Verify the added product is in the checkout page")
    public void verify_the_added_product_is_in_the_checkout_page() {
        List<WebElement> pName = checkout.getProductNames();
        if (pName.size() > 0) {
            for (WebElement e: pName){
                System.out.println(e.getText() + " Displayed on Checkout page");
            }
        } else {
            Assert.fail("No product is added");
        }
    }

    @Then("User clicks on Pay With Card button")
    public void user_clicks_on_pay_with_card_button() {
        checkout.clickOnPayLink();
    }

    @Then("Verify payment popup is displayed")
    public void verify_payment_popup_is_displayed() {
        Assert.assertTrue(checkout.checkOutFormDisplayed());
    }

    @Then("User fills the details")
    public void user_fills_the_details(DataTable dataTable) {
        List<String> list = dataTable.asList();
        for (String a : list) {
            System.out.println(a);
        }
        checkout.enterCardDetail(list);
    }

    @Then("User clicks on payment button")
    public void user_clicks_on_payment_button() {
        checkout.clickOnPayBtn();
    }

    @Then("User gets the {string} message")
    public void user_gets_the_payment_success_message(String expectedMessage) {
            String actualMsg = checkout.getPaymentConfirmation();
            Assert.assertEquals(expectedMessage, actualMsg);
    }
}
