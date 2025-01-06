package c01_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_OzelWebDriver {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup(); // Kendi ozel Webdriver'imizi projeye tanittigimiz satir
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // sirket tarafindan verilen Webdriver'i kullanarak
        // asagidaki testi yapin


        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");


        // phone icin arama yapin
        WebElement aramamaKutusu = driver.findElement(By.id("global-search"));
        aramamaKutusu.sendKeys("phone" + Keys.ENTER);

        // ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();


        // acilan ilk urun sayfasindaki urun isminde
        // case sensitive olmadan "phone" gectigini test edin

        WebElement ilkUrun = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrun = "phone";
        String actualUrun = ilkUrun.getText().toLowerCase(); // case sensitive olmamasi icin

        if (expectedUrun.contains(actualUrun)) {
            System.out.println("İlk urun isim testi Passed");

        } else {
            System.out.println("İlk urun isim testi Failed");
        }


        // sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();


    }
}
