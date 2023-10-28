package selenium_testng_junit.video10_softassertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class AssertClass {
    @Test
    public void testAssert() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(31));
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(driver);
        String expectedURL="https://automationexercise.com/";


        driver.get("https://automationexercise.com");

        String actualURL=driver.getCurrentUrl();
        softAssert.assertEquals(expectedURL,actualURL);
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(5000);
        WebElement allProductElement=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        softAssert.assertTrue(allProductElement.isDisplayed());
        List<WebElement> productListElement= driver.findElements(By.xpath("//*[text()='View Product']"));
        softAssert.assertTrue(productListElement.size()>0);
        WebElement clickProductElement=driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        clickProductElement.click();
        WebElement productDetailElement=driver.findElement(By.xpath("//*[text()='Write Your Review']"));
        softAssert.assertTrue(productDetailElement.isDisplayed());
        WebElement categoryElement= driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        softAssert.assertTrue(categoryElement.isDisplayed());

        softAssert.assertAll();
        driver.close();






    }
}
