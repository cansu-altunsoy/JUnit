package c01_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTestOtomasyon {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidiniz
        driver.get("https://www.testotomasyonu.com/");


        // phone icin arama yapınız

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // arama sonucund urun bulundugunu test edeiniz

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        if (bulunanUrunElementleriList.size() > 0) {
            System.out.println("Urun arama testi passed");
        } else {
            System.out.println("Urun arama testi failed");
        }


        // sayfayi kapatiniz

        ReusableMethods.bekle(3);
        driver.quit();


    }
}
