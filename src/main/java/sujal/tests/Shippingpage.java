package sujal.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sujal.abstractcomponents.Abstractcomponents;

import java.util.List;

public class Shippingpage extends Abstractcomponents{

    WebDriver driver;
    //constructor
    public Shippingpage (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
   private WebElement selectcountry;

    @FindBy(xpath = "//div[@class='payment__shipping']//button")
   private List<WebElement> matchedcountry;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
   private WebElement finalorder;

    public void countryselect()
    {
        selectcountry.sendKeys("ind");
    }

    public WebElement getCountry()
    {
        WebElement finalmatch =matchedcountry.stream().filter(s -> s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
        return finalmatch;
    }

    public Confirmationpage placeorder()
    {
        getCountry().click();
        finalorder.click();
        Confirmationpage confirmationPage = new Confirmationpage(driver);
        return confirmationPage;
    }


}


