package selenium_testng_junit.video2_driverget_methodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethodları {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //websitesi açar
        driver.get("https://www.amazon.com");

        //driver.navigate().to() aynı işlemi yapar ama ileri geri gitmek gibi işlemelre olanak tanır
        driver.navigate().to("https://facebook.com");

        //2- driver.navigate().back() geri gider
        driver.navigate().back();

        //3- driver.navigate().forward() ileri gider
        driver.navigate().forward();

        //4- driver.navigate().refresh() bulunduğumuz sayfayıyeniler
        driver.navigate().refresh();

        //driver.close(); içinde bulunduğu sekmeyi kapatır

        //driver.quit(); bütün sekmeleri kapatır


    }
}
