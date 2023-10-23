package video2_driverget_methodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethodları {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        //1- driver.get("url") --> yazdığımız url ye gider
        driver.get("https://www.amazon.com");

        //2- driver.getTitle() --> içinde olduğu sayfanın başlığını döndürür
        System.out.println(driver.getTitle());

        //3- driver.getCurrentUrl() --> içinde olduğu sayfanın URL ini döndürür
        System.out.println(driver.getCurrentUrl());

        //4- driver.getPageSource(); --> içinde olduğu sayfanın kaynak kodlarını döndürür
        System.out.println(driver.getPageSource());

        //5- driver.getWindowHandle(); --> içinde olduğu sayfanın UNIQUE hash kodunu döndürür
        System.out.println(driver.getWindowHandle());

        //6- driver.getWindowHandles(); --> açıla nbütün tab ların hash kodlarını döndürür




        driver.close();

    }
}
