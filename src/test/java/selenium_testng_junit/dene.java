package selenium_testng_junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class dene {

    @Test
    public void testName() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://github.com/enesbatur01");

        while (true){
            Thread.sleep(1000);
            driver.navigate().refresh();
        }


    }
}
