package api_cucumber.runners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class gameTest {
    @Test
    public void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://discord.com/app");
        Thread.sleep(30000);

        WebElement avlanmaOdası = driver.findElement(By.xpath("//a[@data-list-item-id='channels___1067863003757813841']"));
        WebElement maceramaOdası = driver.findElement(By.xpath("//a[@data-list-item-id='channels___802580381395976203']"));
        Actions action = new Actions(driver);
        int avZamani = 0;

        for (int i = 0; i < 10; i--){
            maceramaOdası.click();
            WebElement mesajKutusu = driver.findElement(By.xpath("//div[@role='textbox']"));
            mesajKutusu.sendKeys("/macera");
            Thread.sleep(3600);
            action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
            Thread.sleep(61000);
            avZamani++;
            System.out.println(avZamani);
            if (avZamani == 6){
                Thread.sleep(36666);
                avlanmaOdası.click();
                WebElement mesajKutusu2 = driver.findElement(By.xpath("//div[@role='textbox']"));
                mesajKutusu2.sendKeys("/avlan");
                Thread.sleep(3000);
                action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
                avZamani=0;
            }

        }




    }
}
