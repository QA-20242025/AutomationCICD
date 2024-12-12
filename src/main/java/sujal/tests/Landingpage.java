package sujal.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sujal.abstractcomponents.Abstractcomponents;

public class Landingpage extends Abstractcomponents {

    WebDriver driver;
    //constructor
    public Landingpage (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement email1;

    @FindBy(id = "userPassword")
    WebElement Password1;

    @FindBy(id = "login")
    WebElement Submit;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errormessage;


    public Productpage loginapp(String email, String Password)
    {
        email1.sendKeys(email);
        Password1.sendKeys(Password);
        Submit.click();
        Productpage productpage = new Productpage(driver);
        return productpage;


    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String errorMessage()
    {
        waitForWebElementToAppear(errormessage);
       String errormsg = errormessage.getText();
       return errormsg;
    }
}
