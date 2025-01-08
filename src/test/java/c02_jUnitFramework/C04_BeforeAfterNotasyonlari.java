package c02_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_BeforeAfterNotasyonlari {


    WebDriver driver;

    @BeforeEach
    public void setup() {

        //Webdriver olusturup ayarlari yapin
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    @AfterEach
    public void teardown() {
        ReusableMethods.bekle(2);
        driver.quit();
    }


    @Test
    public void testOtomasyonuTest() {


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


    }


    @Test
    @Disabled // @Disabled method'u gorunmez yapar calistirmaz
    public void youtubeOtomasyonuTest() {


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


    }


    @Test
    public void wiseOtomasyonuTest() {


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

    }
}
