package video8_actions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.DriverManager;
import java.time.Duration;

public class ActionsDeneme {

    WebDriver driver;
    Actions actions;


    @Before
    public void setUp() throws Exception {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);
    }


    @Test
    public void test01() {
        driver.get("http://automationexercise.com");
        WebElement signupElement= driver.findElement(By.xpath("//a[@href='/login']"));
        actions.click(signupElement).perform();
        WebElement nameElement= driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(nameElement)
                .sendKeys("Enes Çıtır")
                .sendKeys(Keys.TAB)
                .sendKeys("esley.dang@free2ducks.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement genderElement= driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(genderElement)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("pass1A3D.")
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("Feb")
               .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)

                .sendKeys(Keys.TAB)

                .sendKeys(Keys.TAB)
                .sendKeys("Enes")
                .sendKeys(Keys.TAB)
                .sendKeys("Çıtır")
                .sendKeys(Keys.TAB)
                .sendKeys("Pıtırs")
                .sendKeys(Keys.TAB)
                .sendKeys("pamukkale no71")
                .sendKeys(Keys.TAB)
                .sendKeys("Yamukkale no 39")
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys("Ege")
                .sendKeys(Keys.TAB)
                .sendKeys("Denizli")
                .sendKeys(Keys.TAB)
                .sendKeys("20160")
                .sendKeys(Keys.TAB)
                .sendKeys("05318759654")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        String expectedResult="ACCOUNT CREATED!";
        String actualResult = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();

        Assert.assertEquals(expectedResult,actualResult);

        driver.close();


    }
}
