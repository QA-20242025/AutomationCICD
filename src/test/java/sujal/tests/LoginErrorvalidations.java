package sujal.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sujal.TestComponents.BaseTest;
import sujal.TestComponents.Retry;

import java.io.IOException;
import java.util.List;

public class LoginErrorvalidations extends BaseTest {
    String Productname = "ZARA COAT 3";

    @Test(groups = {"ErrorHandling"} , retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException {
        Productpage productpage = landingpage.loginapp("qwertyu@asd.com", "Abcd@123");
        Assert.assertEquals("Incorrect email or password.",landingpage.errorMessage());

    }

    @Test
    public void ProductErrorValidation()
    {
        Productpage productpage = landingpage.loginapp("qwerty@asd.com", "Abcd@123");
        List<WebElement> products = productpage.getProductslist();
        productpage.addProduct(Productname);
        Cartpage Cartpage = productpage.goToCartPage();
        Boolean match = Cartpage.verifyproductMatch("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}
