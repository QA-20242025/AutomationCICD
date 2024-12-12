package sujal.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sujal.abstractcomponents.Abstractcomponents;

import java.util.List;

public class Productpage extends Abstractcomponents {


    WebDriver driver;
//constructor
    public Productpage (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement Spinner;

    By productsby = By.cssSelector(".mb-3");
    By addtocart = By.cssSelector("button[class='btn w-10 rounded']");
    By Toastmessage =(By.cssSelector("#toast-container"));

    public List<WebElement> getProductslist()
    {
        waitForElementToAppear(productsby);
        return products;
    }

    public WebElement getProductByName(String Productname){
        WebElement prod = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().
                        equals(Productname)).findFirst().orElse(null);
        return prod;
    }


        public void addProduct(String Productname)
    {
        WebElement prod = getProductByName(Productname);
        prod.findElement(addtocart).click();
        waitForElementToAppear(Toastmessage);
        waitforElementToDisappear(Spinner);

    }
}
