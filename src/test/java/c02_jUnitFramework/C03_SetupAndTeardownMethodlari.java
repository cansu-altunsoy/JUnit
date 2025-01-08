package c02_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_SetupAndTeardownMethodlari {
    /*
    Kodlamada tekrar eden kodlari sevmeyiz, bir test method'u olusturuldugunda basta olusturmamiz gereken
     driver objesi ve sonda ki kapatma islemi tum methodlar icin lazim
    her test method'unda tekrar tekrar olusturmak yerine methodCall ile kullanmayi tercih edebiliriz
     */

    WebDriver driver;

    public void setup() {

        //Webdriver olusturup ayarlari yapin
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void teardown() {
        ReusableMethods.bekle(2);
        driver.quit();
    }


    @Test
    public void testOtomasyonuTest() {

        setup();

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

        teardown();

    }


    @Test
    public void youtubeOtomasyonuTest() {

        setup();

        // testotomasyonu anasayfaya gidin

        driver.get("https://www.youtube.com/");


        //url'in otomasyon icerdiğini test edin

        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {

            System.out.println("Test passed");

        } else {
            System.out.println("Test Failed");
        }

        teardown();


    }

    @Test
    public void wiseOtomasyonuTest() {

        setup();

        // testotomasyonu anasayfaya gidin

        driver.get("https://www.wisequarter.com/");


        //url'in otomasyon icerdiğini test edin

        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {

            System.out.println("Test passed");

        } else {
            System.out.println("Test Failed");
        }
        teardown();


    }


}
