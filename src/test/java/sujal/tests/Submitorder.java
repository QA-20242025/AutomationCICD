package sujal.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sujal.TestComponents.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Submitorder extends BaseTest {


    @Test(dataProvider = "getDatasets", groups = "Purchase")
    public void getData(HashMap<String, String> input) throws IOException {
        Productpage productpage = landingpage.loginapp(input.get("email"), input.get("password"));
        List<WebElement> products = productpage.getProductslist();
        productpage.addProduct(input.get("Product"));
        Cartpage Cartpage = productpage.goToCartPage();
        Boolean match = Cartpage.verifyproductMatch(input.get("Product"));
        Assert.assertTrue(match);
        Shippingpage Shippingpage = Cartpage.goTocheckOut();
        Shippingpage.countryselect();
        Shippingpage.hold();
        Shippingpage.getCountry();
        Confirmationpage confirmationPage = Shippingpage.placeorder();
        String actualText = confirmationPage.getText();
        String expectedText = "THANKYOU FOR THE ORDER.";
        Assert.assertEquals(actualText, expectedText);


    }

    @Test(dependsOnMethods = {"getData"})
    public void OrderHistoryTest() {
        String Productname = "ZARA COAT 3";
        Productpage productpage = landingpage.loginapp("qwerty@asd.com", "Abcd@123");
        productpage.hold();
        OrderPage orderPage = productpage.goToOrderPage();
        Assert.assertTrue(orderPage.verifyOrderMatch(Productname));

    }


    @DataProvider
    public Object[][] getDatasets() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//sujal//data//PurchaseOrder.json");

        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }
}
/* HashMap<String, String> map = new HashMap<String, String>();
        map.put("email","qwerty@asd.com");
        map.put("password","Abcd@123");
        map.put("Product","ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("email","qwertyuiop@asdf.com");
        map1.put("password","Abcde@123");
        map1.put("Product","ADIDAS ORIGINAL");*/