package c01_Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CokluTest {

    public static void main(String[] args) {

        testOtomasyonuTest();


    }

    public static void testOtomasyonuTest() {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/");


        //url'in otomasyon icerdiğini test edin

        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {

            System.out.println("Test PASSED");

        } else {
            System.out.println("Test FAILED");
        }

        driver.quit();


    }
}
