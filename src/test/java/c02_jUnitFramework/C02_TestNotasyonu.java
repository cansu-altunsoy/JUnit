package c02_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TestNotasyonu {

    /*
    @Test notasyonu siradan bir method'u tek basina Run edilebilir hale getirir

    @Test notasyonu sayesinde her bir testi bagimsiz olarak calıstirabilecegimiz gibi
    class isminin yanindaki run tusu ile class'daki Tum test method'larini toplu olarak da calistirabiliriz

    JUnit @Test method'larin calıisma sirasini kendine gore duzenler
    belirlenmis bir siralama duzeni yoktur, siralamayi ongoremeyiz ve kontrol edemeyiz

    eger sirali calismasini istedigimiz test method'lari olursa,
    isimlerin test01, test02, test03 diye belirleye biliriz, siraya uygun calisir bu isimlendirme ile
     */


    @Test
    public void testOtomasyonuTest() {

        //Webdriver olusturup ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com/");


        //url'in otomasyon icerdiğini test edin

        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {

            System.out.println("Test passed");

        } else {
            System.out.println("Test Failed");
        }

        driver.quit();


    }

    @Test
    public void youtubeOtomasyonuTest() {

        //Webdriver olusturup ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // youtube anasayfaya gidin

        driver.get("https://www.youtube.com/");


        //url'in otomasyon icerdiğini test edin

        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {

            System.out.println("Test passed");

        } else {
            System.out.println("Test Failed");
        }

        driver.quit();


    }

    @Test
    public void wiseOtomasyonuTest() {

        //Webdriver olusturup ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //  wisequarter anasayfaya gidin

        driver.get("https://www.wisequarter.com/");


        //url'in otomasyon icerdiğini test edin

        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {

            System.out.println("Test passed");

        } else {
            System.out.println("Test Failed");
        }

        driver.quit();


    }


}
