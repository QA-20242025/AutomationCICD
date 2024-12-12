package sujal.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sujal.abstractcomponents.Abstractcomponents;

import java.util.List;

public class OrderPage extends Abstractcomponents {

    WebDriver driver;

    //constructor
    public OrderPage (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tbody/tr/td[2]")
    List<WebElement> Orderproductname;



    public boolean verifyOrderMatch(String Productname)
    {
        Boolean match = Orderproductname.stream().anyMatch(cp -> cp.getText().equalsIgnoreCase(Productname));
        return match;
    }



}
