package video1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IlkClass {
    public static void main(String[] args) throws InterruptedException {
        //driver kurmak

        //webdriver oluşturma
        WebDriver driver= new ChromeDriver();

        //websitesi açma
        driver.get("https://www.amazon.com");

    }
}
