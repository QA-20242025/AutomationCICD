package sujal.abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sujal.tests.Cartpage;
import sujal.tests.OrderPage;

import java.time.Duration;


public class Abstractcomponents {
    WebDriver driver;
    @FindBy(css = "[routerlink*='cart']")
    WebElement cartheader;

    @FindBy(css = "button[routerlink='/dashboard/myorders']")
    WebElement Orderheader;



    public Abstractcomponents(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForElementToAppear(By findby)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));

    }

    public void waitForWebElementToAppear(WebElement findby)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findby));

    }

    public void waitforElementToDisappear(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public Cartpage goToCartPage()
    {
        cartheader.click();
        Cartpage Cartpage = new Cartpage(driver);
        return Cartpage;
    }

    public OrderPage goToOrderPage()
    {
        Orderheader.click();
        OrderPage orderpage = new OrderPage(driver);
        return orderpage;
    }


    public void hold()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }




}
