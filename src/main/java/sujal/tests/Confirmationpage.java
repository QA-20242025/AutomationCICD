package sujal.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sujal.abstractcomponents.Abstractcomponents;

public class Confirmationpage extends Abstractcomponents {
    WebDriver driver;

    //constructor
    public Confirmationpage (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".hero-primary")
    WebElement text;

    public String getText()
    {
       String textgot = text.getText();
       return textgot;
    }


}


