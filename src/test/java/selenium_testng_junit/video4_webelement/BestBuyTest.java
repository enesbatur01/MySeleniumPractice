package selenium_testng_junit.video4_webelement;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BestBuyTest {

    @Test
    public void BestBuyTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com");
        List<WebElement>buttonList=driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());

        for (WebElement w : buttonList){
            System.out.println(w.getText());
        }




    }
}
