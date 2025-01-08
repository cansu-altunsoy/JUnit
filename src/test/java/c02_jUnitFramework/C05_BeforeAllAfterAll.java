package c02_jUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_BeforeAllAfterAll {

    /*
    Bu gorev icin her test method'unda sonra driver'i kapatmak (@AfterEach) mantikli degil

    bunun yerine
    class calismaya basladiginda hic bir method calismadan once driver'i olusturmak
     ve tum @Test method'lari calisip bittikten sonra,
     calisacak @Test method'u kalmadiginda driver'i kapatmak daha mantikli our


     Bu tur birbirinin sonucuna bagli test method'lari oldugunda
     JUnit ile method'lari tek tek Run edebiliriz
     ancak method'un yapmasi gereken islevi yapmasi mumkun olmayabilir

       @BeforeAll ve  @AfterAll notasyonu kullanan method'larin mutlaka static olmasi gerekir

     */

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklerstirin
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }


    @Test
    public void test01() { // anasayfaTesti
        // 1- method testotomasyonu ana sayfaya gidin ve
        // url testotomasyonu icerdigini kontrol edin

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Anasayfa testi PASSED");
        } else System.out.println("Anasayfa testi FAILED");

    }

    @Test
    public void test02() { // urunaramaTesti
        // 2- method'da phone icin arama yapin ve
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunca urun bulunabildigini test edin
        List<WebElement> bulunanUrunSayisi = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualUrunSayisi = bulunanUrunSayisi.size();

        if (actualUrunSayisi > 0) {
            System.out.println("Urun bulma testi PASSED");
        } else System.out.println("Urun bulma testi FAILED");

    }

    @Test
    public void test03() { //ilkUrunIsimTesti

        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();


        // ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin
        WebElement ilkUrunIsmiElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimicerik = "phone";
        String actualIsimicerik = ilkUrunIsmiElementi.getText().toLowerCase();

        if (actualIsimicerik.contains(expectedIsimicerik)) {
            System.out.println("Urun isim testi PASSED");
        } else System.out.println("Urun isim testi FAILED");


    }
}
