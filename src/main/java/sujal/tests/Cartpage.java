package sujal.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sujal.abstractcomponents.Abstractcomponents;

import java.util.List;

public class Cartpage extends Abstractcomponents {

    WebDriver driver;

    //constructor
    public Cartpage (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartproductname;

    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

    public boolean verifyproductMatch(String Productname)
    {
        Boolean match = cartproductname.stream().anyMatch(cp -> cp.getText().equalsIgnoreCase(Productname));
        return match;
    }

    public Shippingpage goTocheckOut()
    {
        checkoutButton.click();
        Shippingpage Shippingpage = new Shippingpage(driver);
        return Shippingpage;

    }

}
