package sujal.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Standalonetesting {

    @Test
    public void getData() {
        String xyz = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("qwerty@asd.com");
        driver.findElement(By.id("userPassword")).sendKeys("Abcd@123");
        driver.findElement(By.id("login")).click();

        Landingpage landingpage = new Landingpage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().
                        equals(xyz)).findFirst().orElse(null);

        prod.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        List<WebElement> cartproductname = driver.findElements(By.cssSelector(".cartSection h3")) ;
                       Boolean match =    cartproductname.stream().anyMatch(cp -> cp.getText().equalsIgnoreCase(xyz));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      List<WebElement> country =  driver.findElements(By.xpath("//div[@class='payment__shipping']//button"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement countryname = country.stream().filter(s -> s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
        countryname.click();

        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
       String text = driver.findElement(By.cssSelector(".hero-primary")).getText();
       String text1 = "THANKYOU FOR THE ORDER.";
       Assert.assertEquals(text,text1);
       driver.close();
    }
}
