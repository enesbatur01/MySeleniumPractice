package video4_webelement;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FacebookTest {

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
    }





}
