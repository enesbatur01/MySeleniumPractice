package selenium_testng_junit.video5_junitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_TestNotasyonu {


    @Test
    public void amazonTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='field-keywords']"));
        searchBox.sendKeys("nutella");
        searchBox.submit();
        WebElement result= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
        driver.close();
    }


    @Test
    public void facebookTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https:www.facebook.com");
        WebElement mailBox=driver.findElement(By.xpath("//input[@id='email']"));
        mailBox.sendKeys("JJLsfjdhljksfd");
        WebElement passBox = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
        passBox.sendKeys("dşlsa64ASD.");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")).click();
        String actualData=driver.findElement(By.xpath("//div[@class='fsl fwb fcb']")).getText();
        String expectedData="Giriş Bilgileri Yanlış";
        driver.close();
        Assert.assertEquals(expectedData,actualData);
        driver.close();
    }


    @Test
    public void bestBuyTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com");
        List<WebElement> buttonList=driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());

        for (WebElement w : buttonList){
            System.out.println(w.getText());
        }

        driver.close();

    }


}
