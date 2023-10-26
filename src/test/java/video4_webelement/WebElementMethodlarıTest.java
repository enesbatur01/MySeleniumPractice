package video4_webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElementMethodlarıTest {
    public static void main(String[] args) {
        //driver oluştur
        WebDriver driver = new ChromeDriver();

        //tam ekran yap
        driver.manage().window().maximize();

        //15 saniye bekle
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sitesine git
        driver.get("https://www.amazon.com");

        //arama kutusunun webelementini al
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='field-keywords']"));

        //nutella yazdır
        searchBox.sendKeys("nutella");

        //enter a bas
        searchBox.submit();

        //sonuç için webelementi al
        WebElement result= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        //sonucu yazdır
        System.out.println(result.getText());
        driver.close();


    }
}
