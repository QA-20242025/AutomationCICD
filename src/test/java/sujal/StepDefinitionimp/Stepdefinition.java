package sujal.StepDefinitionimp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sujal.TestComponents.BaseTest;
import sujal.tests.*;

import java.io.IOException;
import java.util.List;

public class Stepdefinition extends BaseTest {

    public Landingpage landingpage;
    public Productpage productpage;
    public Confirmationpage confirmationPage;
    @Given("I landed on Ecommerce page")
    public void I_landed_on_Ecommerce_page() throws IOException {
        landingpage  = launchapp();
    }

    @Given ("^Logged in with username (.+) and password   (.+)$")
    public void Logged_in_with_username_and_password(String username , String password)
    {
        productpage = landingpage.loginapp(username,password);
    }

    @When("^I add product (.+) to cart$")
    public void I_add_product_to_cart(String productname)
    {
        List<WebElement> products = productpage.getProductslist();
        productpage.addProduct(productname);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productname)
    {
        Cartpage Cartpage = productpage.goToCartPage();
        Boolean match = Cartpage.verifyproductMatch(productname);
        Assert.assertTrue(match);
        Shippingpage Shippingpage = Cartpage.goTocheckOut();
        Shippingpage.countryselect();
        Shippingpage.hold();
        Shippingpage.getCountry();
        confirmationPage = Shippingpage.placeorder();
    }

    @Then("{string} message is displayed on confirmationpage")
    public void message_displayed_confirmationpage(String string)
    {
        String actualText = confirmationPage.getText();
        String expectedText = string;
        Assert.assertEquals(actualText, expectedText);
        driver.close();
    }

    @Then("{string} error message displayed")
    public void error_message_displayed(String string)
    {
        Assert.assertEquals(string,landingpage.errorMessage());
        driver.close();
    }


}
