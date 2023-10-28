package selenium_testng_junit.video5_junitFramework;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Before_After_Notasyonları {

   WebDriver driver;


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void name() throws InterruptedException {
        driver.get("https://web.whatsapp.com/");
        Thread.sleep(50000);

        driver.findElement(By.xpath("//span[@title='Büşram']")).click();
        for (int i = 0; i < 1001; i++) {
            WebElement messageBox=driver.findElement(By.xpath("(//p[@class='selectable-text copyable-text iq0m558w g0rxnol2'])[2]"));
            messageBox.sendKeys("sev beni lann hemen "+i);
            driver.findElement(By.xpath("//span[@data-icon='send']")).click();
        }



    }
}
