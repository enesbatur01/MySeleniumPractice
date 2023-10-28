package selenium_testng_junit.video3_webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locator {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com");

        //name e göre elementalır
        WebElement searchBar = driver.findElement(By.name("field-keywords"));

        //classname e göre alma
        searchBar= driver.findElement(By.className("nav-input nav-progressive-attribute"));

        //id ye göre alma
        searchBar= driver.findElement(By.id("twotabsearchtextbox"));

        //link textine göre alma
        searchBar= driver.findElement(By.linkText("Turkey"));

        //linkname in unique olacak  şekilde bir kısmını almak
        searchBar= driver.findElement(By.partialLinkText("ey"));

        //tag e göre alma
        searchBar= driver.findElement(By.tagName("//input"));

        //xpath en güçlüsü
        searchBar= driver.findElement(By.xpath("//input[@name='field-keywords'][1]"));


    }
}
