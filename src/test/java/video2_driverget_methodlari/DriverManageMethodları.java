package video2_driverget_methodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMethodları {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        //WINDOW METHODLARI --------------------------------------------------------------------

        //driver.manage().window().getSize() içinde bulunduğumuz sayfanın ölçülerini getirir
        System.out.println(driver.manage().window().getSize());

        //driver.manage().window().getPosition() içinde olduğu sayfanın pixel olarak konumunu verir. sol alt köşeden baz alır
        System.out.println(driver.manage().window().getPosition());

        //driver.manage().window().setPosition(new Point(35,35)); sayfanın pozisyonunu ayarlar
        driver.manage().window().setPosition(new Point(35,35));

        //driver.manager().window().setsize()new Dimension() sayfa boyutunu ayarlar
        driver.manage().window().setSize(new Dimension(1920,1080));

        //driver.manage().window().fullscreen(); sayfayı fullscreen yapar
        //driver.manage().window().maximize(); sayfayı maximize yapar
        driver.manage().window().fullscreen();

        //driver.manage().window.minimize simgeye küçültür
        driver.manage().window().minimize();

        //TIMEOUTS METHODLARI ----------------------------------------------------------------------------------------------
        /*
        driverımıza sayfanın yüklenmesi ve web elementlerin bulunması için bekleyeceği bir maksimum süre belirtir
        driver bu süre içerisinde sayfa açılırsa açılır, webelementi bulursa bulur. Bulamazsa bir exception fırlatır.
        eğer erken bulursa beklemez ve devam eder
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //sayfalara hep maximize ve implicitlywait eklemeliyiz ki bazı kodların çalışmama problemiş ortadan kalksın





    }
}
