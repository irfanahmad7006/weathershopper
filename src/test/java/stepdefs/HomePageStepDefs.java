package stepdefs;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import weatherShopPages.HomePage;

public class HomePageStepDefs {
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    String title;

    @Given("User is on weather shopping home page")
    public void user_is_on_weather_shopping_home_page() {
        title = homePage.getTitle();
    }

    @Given("User verifies the title {string} of the page")
    public void user_verifies_the_title_of_the_page(String title) {
        Assert.assertEquals(this.title, title);
    }

    @When("User clicks on Buy Moisturizers button OR Buy Sunscreens button based on current temperature")
    public void user_clicks_on_buy_moisturizers_button_or_buy_sunscreens_button_based_on_current_temperature() {
        if (homePage.getTemp() < 19) {
            homePage.clickOnMoist();
            System.out.println("Buy Moisturizers clicked");
        } else if (homePage.getTemp() > 34) {
            homePage.clickOnSunscrn();
            System.out.println("Buy Sunscreens clicked");
        } else {
            Assert.fail("Temperature is between 19 and 34 degrees Celsius");
        }
    }
}
